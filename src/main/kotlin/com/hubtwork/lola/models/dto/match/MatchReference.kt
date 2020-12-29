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
 *  6. platformId ( String )            ( platform Info :: KR, NA , ... )
 *
 *
 *  return ArrayList<MatchInfo>
 */

data class MatchReference(
    var platformId: String,
    var gameId: Long,       // matchId
    var champion: Int,
    var queue: Int,
    var season: Int,
    var timestamp: Long,
    var role: String,       // ?            ( DUO, SOLO, NONE ... etc )
    var lane: String       // 큐 돌릴 때 선택한 라인
)
