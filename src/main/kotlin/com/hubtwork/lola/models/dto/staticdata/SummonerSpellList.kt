package com.hubtwork.lola.models.dto.staticdata

/**
 *      DTO for Summoner Spell
 *
 *          request :: http://ddragon.leagueoflegends.com/cdn/{ dd_ver }/data/{ platform }/summoner.json
 *
 */
data class SummonerSpellList (
    var type: String,
    var version: String,

    var data: Map<String, SummonerSpell>

)