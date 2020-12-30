package com.hubtwork.lola.models.dto.staticdata

/**
 *      DTO for Detail Data About Target Champion
 *          - request: http://ddragon.leagueoflegends.com/cdn/{ dd_ver }/data/{ language }/champion/{ champion key(eng name) }.json
 *
 *      1. type :: dd data info type ( champion )
 *      2. format :: standAloneComplex ( ? )
 *      3. version :: current Champion Data's DD Version
 *
 *      data :: Detail Data About Target Champion ( Include recommend Set also )
 *
 */
data class ChampionDetail(
    var type: String,
    var format: String,
    var version: String,

    var data: ChampionDetailInfo
)
