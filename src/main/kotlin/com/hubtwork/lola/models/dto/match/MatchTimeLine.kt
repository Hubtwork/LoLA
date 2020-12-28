package com.hubtwork.lola.models.dto.match

data class MatchTimeLine(
    var participantId: Int,
    /**
     *  Role : (Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT)
     *  Lane : (Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM)
     *
     *
     */
    var role: String,
    var lane: String,
)
