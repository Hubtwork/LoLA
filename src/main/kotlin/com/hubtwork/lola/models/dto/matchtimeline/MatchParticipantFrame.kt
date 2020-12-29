package com.hubtwork.lola.models.dto.matchtimeline

data class MatchParticipantFrame (
    var participantId: Int,
    var minionsKilled: Int,
    var teamScore: Int,
    var dominionScore: Int,
    var totalGold: Int,
    var level: Int,
    var xp: Int,
    var currentGold: Int,
    var position: MatchPosition,
    var jungleMinionsKilled: Int
)