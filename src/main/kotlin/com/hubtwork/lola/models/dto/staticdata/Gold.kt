package com.hubtwork.lola.models.dto.staticdata


/**
 *  DTO About Gold For Item Data.
 *
 */
data class Gold(
    var base: Int,      // 단일 가격
    var purchasable: Boolean,
    var total: Int,     // 제작 총 가격
    var sell: Int       // 판매 가격
)
