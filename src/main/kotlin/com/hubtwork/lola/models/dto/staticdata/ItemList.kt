package com.hubtwork.lola.models.dto.staticdata

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ItemList(
    var version: String,
    var type: String,

    var data: Map<String, Item>,        // Map < Item-Key, Item > 맵

    var groups: ArrayList<Group>,
    var tree: ArrayList<ItemTree>
)