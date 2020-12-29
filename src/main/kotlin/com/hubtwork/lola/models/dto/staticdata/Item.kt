package com.hubtwork.lola.models.dto.staticdata

/**
 *
 *  ITEM DTO Request
 *      URL - http://ddragon.leagueoflegends.com/cdn/{ data dragon ver }/data/{ platform }/item.json
 *
 *
 */
data class Item(
    var name: String,
    var description: String,
    var colloq: String,
    var plaintext: String,
    var into: ArrayList<String> = ArrayList<String>(),
    var image: Image,
    var gold: Gold,
    var tags: ArrayList<String>,
    var maps: Map<String, Boolean>,
    // var stats: ArrayList<Stat>,
)