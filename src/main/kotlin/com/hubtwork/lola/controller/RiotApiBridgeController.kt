package com.hubtwork.lola.controller

import com.google.gson.Gson
import com.hubtwork.lola.service.riotAPI.RiotApiBridgeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/api/v1/riot")
class RiotApiBridge(private val restTemplate: RestTemplate, private val gson: Gson) {

    private var riotApiService = RiotApiBridgeService(restTemplate)

    @GetMapping("/lol/summoner/{summoner_name}")
    fun getLolSummoner(@PathVariable("summoner_name") name: String): String {
        val summonerSearchResult = riotApiService.getSummonerStatsBySummonerName(name)
        System.out.print(gson.toJson(summonerSearchResult))
        return gson.toJson(summonerSearchResult)
    }

    @GetMapping("/lol/realm/{platform}")
    fun getRealm(@PathVariable("platform") platform: String): String {
        val realmSearchResult = riotApiService.checkDataDragonRegion(platform)
        // System.out.print(realmSearchResult?.n?.get("item"))
        return gson.toJson(realmSearchResult)
    }

    @GetMapping("/lol/item/{platform}/{itemId}")
    fun getAllItem(@PathVariable("platform") platform: String, @PathVariable("itemId") itemId: String): String {
        val itemResult = riotApiService.getSpecificItem(platform, itemId)?.let {
            return gson.toJson(it)
        }
        return "Error - No Item Found ( There's No Item key : $itemId )"
    }
    /**
    @GetMapping("/lol/stats/{summoner_name}")
    fun getLolSummonerStats(@PathVariable("summoner_name") name: String): String? {
        val summonerBasic = getLolSummoner(name)
        summonerBasic?.let {
            val summonerStat = riotClient.get()
                    .uri { it.pathSegment(RiotApiConst.uri_LOL, RiotApiConst.uri_sum_stat_1, RiotApiConst.uri_sum_stat_2, RiotApiConst.uri_sum_stat_3, RiotApiConst.uri_sum_stat_4, summonerBasic.id).build() }
                    .retrieve()
                    .bodyToMono(typeReference<List<SummonerLeagueStat>>())
                    .block()
            var rankStats = ArrayList<CompiledRankStat>()
            summonerStat?.let {
                for ( stat in summonerStat) {
                    val rankType = Translator.rank_type_translator(stat.queueType)
                    val rankStat = Translator.rank_stat_stringBuilder(stat.tier, stat.rank, stat.leaguePoints)
                    val rankWin = stat.wins
                    val rankLose = stat.losses
                    val winningRate = ((1000 * (rankWin.toDouble() / (rankWin + rankLose))).roundToInt().toDouble())/10
                    rankStats.add(CompiledRankStat(rankType, rankStat, rankWin, rankLose, winningRate))
                }
                return CompiledSummonerSummary(summonerBasic.name, summonerBasic.profileIconId, summonerBasic.summonerLevel, rankStats).toString()
            }
        }
        return "Error : load Failed"
    }
    */



}

inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}