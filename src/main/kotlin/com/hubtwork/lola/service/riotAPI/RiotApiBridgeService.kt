package com.hubtwork.lola.service.riotAPI

import com.google.gson.Gson
import com.hubtwork.lola.common.config.RiotApiConst
import com.hubtwork.lola.models.dto.compiled_dto.CompiledRankStat
import com.hubtwork.lola.models.dto.compiled_dto.CompiledSummonerSummary
import com.hubtwork.lola.models.dto.staticdata.Champion
import com.hubtwork.lola.models.dto.staticdata.Item
import com.hubtwork.lola.models.dto.staticdata.ItemList
import com.hubtwork.lola.models.dto.staticdata.Realm
import com.hubtwork.lola.models.dto.summoner.SummonerBasic
import com.hubtwork.lola.models.dto.summoner.SummonerLeagueStat
import com.hubtwork.lola.modules.lolTranslate.Translator
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

@Service
class RiotApiBridgeService(private val restTemplate: RestTemplate){

    private val gson = Gson()

    fun getSummonerInfoBySummonerName(name: String): SummonerBasic =
        restTemplate.getForObject(arrayListOf(RiotApiConst.uri_summoner,name).joinToString(separator = "/" ), SummonerBasic::class)

    fun getSummonerStatsBySummonerName(name: String): CompiledSummonerSummary {
        val summonerBasic = getSummonerInfoBySummonerName(name)
        var rankStats: ArrayList<CompiledRankStat> = ArrayList()

        val summonerStatEntity: ResponseEntity<ArrayList<SummonerLeagueStat>> = restTemplate.exchange(arrayListOf(RiotApiConst.uri_summoner_stat, summonerBasic.id).joinToString(separator = "/"), HttpMethod.GET, null, typeReference<ArrayList<SummonerLeagueStat>>())
        val statList: ArrayList<SummonerLeagueStat>? = summonerStatEntity.body
        if (statList != null) {
            for (stat in statList) {
                val rankType = Translator.rank_type_translator(stat.queueType)
                val rankStat = Translator.rank_stat_stringBuilder(stat.tier, stat.rank, stat.leaguePoints)
                val rankWin = stat.wins
                val rankLose = stat.losses
                val winningRate = ((1000 * (rankWin.toDouble() / (rankWin + rankLose))).roundToInt().toDouble())/10
                rankStats.add(CompiledRankStat(rankType, rankStat, rankWin, rankLose, winningRate))
            }
        }
        return CompiledSummonerSummary(summonerBasic.name, summonerBasic.profileIconId, summonerBasic.summonerLevel, rankStats)
    }

    fun getDataDragonVer(): String =
        restTemplate.getForObject(RiotApiConst.uri_datadragon_version, String::class)

    fun checkDataDragonRegion(platform: String): Realm? {
        val url =
            arrayListOf(RiotApiConst.uri_datadragon_region_check, ("$platform.json")).joinToString(separator = "/")
        val realmResult: ResponseEntity<Realm> = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            Realm::class.java
        )
        return realmResult.body
    }


    // Deprecated
    /*
    fun getDataDragonItem(platform: String): String {
        val realm: Realm? = checkDataDragonRegion(platform)
        realm?.let {
            val url = RiotApiConst.uri_datadragon_item(realm.n["item"]!!, realm.l)
            val itemResult: ResponseEntity<ItemList> = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                ItemList::class.java
                )
            print(itemResult.body?.data?.get("1001"))
            return gson.toJson(itemResult.body)
        }
        return "Error - Realm did not found"
    }
     */

    fun getSpecificChampion(platform: String, championName: String) : Champion? {
        val realm: Realm? = checkDataDragonRegion(platform)


        return null
    }

    fun getSpecificItem(platform: String, itemId: String) : Item? {
        val realm: Realm? = checkDataDragonRegion(platform)
        realm?.let {
            val url = RiotApiConst.uri_datadragon_item(realm.n["item"]!!, realm.l)
            val itemListJson: ResponseEntity<ItemList> = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                ItemList::class.java
            )
            val item = itemListJson.body!!.data[itemId].let {
                return it
            }
            return null
        }
        return null
    }

    /**
    fun getSummonerStats(name: String): Flux<SummonerLeagueStat> {
        val summonerBasic = getSummonerInfoBySummonerName(name)
        var rankStats = ArrayList<CompiledRankStat>()
        val summonerStats = riotApiClient.get()
                                .uri { it.pathSegment(RiotApiConst.uri_LOL, RiotApiConst.uri_sum_stat_1, RiotApiConst.uri_sum_stat_2, RiotApiConst.uri_sum_stat_3, RiotApiConst.uri_sum_stat_4, summonerBasic.id).build() }
                                .retrieve()
                                .bodyToFlux(SummonerLeagueStat::class.java)
        /**
        for ( stat in summonerStats) {
            val rankType = Translator.rank_type_translator(stat.queueType)
            val rankStat = Translator.rank_stat_stringBuilder(stat.tier, stat.rank, stat.leaguePoints)
            val rankWin = stat.wins
            val rankLose = stat.losses
            val winningRate = ((1000 * (rankWin.toDouble() / (rankWin + rankLose))).roundToInt().toDouble())/10
            rankStats.add(CompiledRankStat(rankType, rankStat, rankWin, rankLose, winningRate))
        }
        return CompiledSummonerSummary(summonerBasic.name, summonerBasic.profileIconId, summonerBasic.summonerLevel, rankStats)
*/
        return summonerStats
    }
    */





}

// ParameterizedTypeReference :: Array 형태의 JSON Object 매핑
inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}