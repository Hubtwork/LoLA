package com.hubtwork.lola.models.dto.staticdata

data class ChampionList(
    var type: String,
    var format: String,
    var version: String,

    var data: Map<String, Champion>,
)
