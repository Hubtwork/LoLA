package com.hubtwork.lola.riotAPI

import com.hubtwork.lola.config.RiotApiConst
import com.hubtwork.lola.models.SummonerBasic
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient


@RestController
@RequestMapping("/api/v1/riot")
class RiotApiBridge(private val riotClient: WebClient) {

    @GetMapping("/lol/summoner/{summoner_name}")
    fun getLolSummoner(@PathVariable("summoner_name") name: String): SummonerBasic? =
            riotClient.get()
                    .uri { it.pathSegment(RiotApiConst.uri_LOL, RiotApiConst.uri_summoner_1, RiotApiConst.uri_summoner_2, RiotApiConst.uri_summoner_3, RiotApiConst.uri_summoner_4, name).build() }
                    .retrieve()
                    .bodyToMono(SummonerBasic::class.java)
                    .block()
}