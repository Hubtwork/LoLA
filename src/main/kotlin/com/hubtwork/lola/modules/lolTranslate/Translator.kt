package com.hubtwork.lola.modules.lolTranslate



object Translator {

    fun rank_type_translator(rank_type: String) =
            when (rank_type) {
                "RANKED_SOLO_5x5" -> "솔로 랭크"
                "RANKED_FLEX_SR" -> "자유 랭크"
                else -> rank_type
            }

    fun rank_stat_stringBuilder(tier: String, tier_level: String, point: Int) = StringBuilder()
            .append("${tier} ").append(tier_level).append(" ${point}LP")
            .toString()

}