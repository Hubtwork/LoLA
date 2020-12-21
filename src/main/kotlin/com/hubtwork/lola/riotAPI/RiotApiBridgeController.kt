package com.hubtwork.lola.riotAPI

import com.hubtwork.lola.config.RiotApiConst
import com.hubtwork.lola.models.CompiledRankStat
import com.hubtwork.lola.models.SummonerBasic
import com.hubtwork.lola.models.SummonerLeagueStat
import com.hubtwork.lola.models.SummonerSummary
import com.hubtwork.lola.modules.lolTranslate.Translator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.core.ParameterizedTypeReference
import java.lang.Math.round


@RestController
@RequestMapping("/api/v1/riot")
class RiotApiBridge(private val riotClient: WebClient) {

    companion object

    @GetMapping("/lol/summoner/{summoner_name}")
    fun getLolSummoner(@PathVariable("summoner_name") name: String): SummonerBasic? =
            riotClient.get()
                    .uri { it.pathSegment(RiotApiConst.uri_LOL, RiotApiConst.uri_sum_1, RiotApiConst.uri_sum_2, RiotApiConst.uri_sum_3, RiotApiConst.uri_sum_4, name).build() }
                    .retrieve()
                    .bodyToMono(SummonerBasic::class.java)
                    .block()

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
                    val winningRate = round(1000 * (rankWin.toDouble()/(rankWin+rankLose))).toDouble()/10
                    var compiledRank = CompiledRankStat(rankType, rankStat, rankWin, rankLose, winningRate)
                    rankStats.add(compiledRank)
                }
                return SummonerSummary(summonerBasic.name, summonerBasic.profileIconId, summonerBasic.summonerLevel, rankStats).toString()
            }
        }
        return "Error : load Failed"
    }



}

inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}