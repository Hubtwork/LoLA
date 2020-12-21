package com.hubtwork.lola.models.riotApiBridge.compiledDTO

/**
 *      DTO for FrontEnd Client about searching Summoner Summary Info by summoner name
 *
 *      1. 소환사 명
 *      2. 프로필 아이콘
 *      3. 소환사 레벨
 *      4. 랭크 티어 정보 [ 솔랭 / 자유랭 ]
 *
 */
data class CompiledSummonerSummary(
        var summonerName: String,
        var profileIconId: Int,
        var summonerLevel: Long,

        var rankTierInfo: ArrayList<CompiledRankStat>
)

data class CompiledRankStat(
        var rankType: String,
        var rankStat: String,    // 티어 + 랭크 + 점수
        var rankWin: Int,
        var rankLose: Int,
        var winningRate: Double // 승률 : 소수점 1자리까지 .
)