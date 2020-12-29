package com.hubtwork.lola.models.dto.matchtimeline


/**
 *
 *
 *
 *
 *
 */
data class MatchEvent(
    var laneType: String,       //
    var skillSlot: Int,
    var ascendedType: String,
    var creatorId: Int,
    var afterId: Int,
    var eventType: String,

    /**
     *          Type : (Legal values)
     *
     * CHAMPION_KILL,
     *
     * WARD_PLACED,
     *
     * WARD_KILL,
     *
     * BUILDING_KILL,
     *
     * ELITE_MONSTER_KILL,
     *
     * ITEM_PURCHASED,
     *
     * ITEM_SOLD,
     *
     * ITEM_DESTROYED,
     *
     * ITEM_UNDO,
     *
     * SKILL_LEVEL_UP,
     *
     * ASCENDED_EVENT,
     *
     * CAPTURE_POINT,
     *
     * PORO_KING_SUMMON
     *
     */
    var type: String,

    var levelUpType: String,
    var wardType: String,
    var participantId: Int,
    var towerType: String,
    var ItemId: Int,
    var beforeId: Int,
    var pointCaptured: String,
    var monsterType: String,
    var monsterSubType: String,
    var teamId: Int,
    var position: MatchPosition,
    var killerId: Int,
    var timestamp: Long,
    var assistingParticipantIds: List<Int>,
    var buildingType: String,
    var victimId: Int
)
