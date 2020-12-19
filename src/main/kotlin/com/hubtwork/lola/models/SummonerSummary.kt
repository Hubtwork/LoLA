package com.hubtwork.lola.models

data class SummonerSummary(
        var summonerName: String,
        var profileIconId: Int,
        var summonerLevel: Long,

        var rankTierInfo: ArrayList<CompiledRankStat>
)
