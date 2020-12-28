package com.hubtwork.lola.models.dto.match

/**
 *          get match Info of particular Summoner
 *
 * response about "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{encryptedSummonerId}"
 *
 * get Parameters ( Optional )
 *  1. champion (int)                   ( champion targeting )
 *  2. queue    (int)                   ( queue ID targeting )
 *  3. season   (int)                   ( season targeting :: deprecated )
 *  4. beginTime & endTime ( long )     ( filtering by time )
 *  5. beginIndex & endIndex ( int )    ( filtering by index Range - maximum range : 100 )
 *
 *  return ArrayList<MatchInfo>
 */

data class MatchListInfo(
    var season: Int,
    var gameId: Long,       // matchId
    var role: String,       // ?
    var champion: Int,
    var queue: Int,
    var lane: String,       // 큐 돌릴 때 선택한 라인
    var timestamp: Long
)
