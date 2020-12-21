package com.hubtwork.lola.models.riotApiBridge.matchDetail

/**
 *  DTO for participant Detail
 */

data class MatchParticipantInfo(
    var participantId: Int,
    var teamId: Int,
    var championId: Int,
    var spell1Id: Int,
    var spell2Id: Int,
    var stat: MatchParticipantStat,
)

