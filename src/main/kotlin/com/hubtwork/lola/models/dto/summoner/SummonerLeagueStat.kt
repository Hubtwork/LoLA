package com.hubtwork.lola.models.dto.summoner

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 *              get summoner Basic DATA by Summoner Name
 *
 *  response about "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{Encrypted Summoner Id}"
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class SummonerLeagueStat(
        var summonerId: String, // Encrypted Summoner ID
        var summonerName: String,
        var queueType: String,  // 랭크 종류
        var tier: String,   // 현재 티어
        var rank: String,   // 랭크 ( 티어 단계 )
        var leaguePoints: Int, // 점수
        var wins: Int,  // 승리 수
        var losses: Int,    // 패배 수
        // 아래 사항은 개발자 포럼 참고해볼 것
        var veteran: Boolean,
        var inactive: Boolean,
        var freshBlood: Boolean,
        var hotStreak: Boolean
)
