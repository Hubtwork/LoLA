package com.hubtwork.lola.models.dto.staticdata

/**
 *
 *  ITEM DTO Request
 *      URL - http://ddragon.leagueoflegends.com/cdn/{ data dragon ver }/data/{ platform }/item.json
 *
 *      * Image URL
 *      - http://ddragon.leagueoflegends.com/cdn/{ dd_ver }/img/item/{ item-Key }.png
 *
 *
 */
data class Item(
    var name: String,               // Item name
    var description: String,        // Description about item
    var colloq: String,
    var plaintext: String,          // 'On Mouse' description about item
    var requiredChampion: String = "",   // Needed Champion to buy this item

    var from: ArrayList<String> = ArrayList<String>(),      // Item tree ( parent items )
    var into: ArrayList<String> = ArrayList<String>(),      // Item tree ( child items )

    var effect: Map<String, String> = mapOf(),    // Effect1 ~ check for values. ( It's

    var image: Image,
    var gold: Gold,
    var tags: ArrayList<String>,    // Tags for describing Item. ( ex_ AttackSpeed, CriticalStrike, ... )
    var maps: Map<String, Boolean>,
    // var stats: ArrayList<Stat>,

    var depth: Int,
    var specialRecipe: Int,
    var stacks: Int,
)