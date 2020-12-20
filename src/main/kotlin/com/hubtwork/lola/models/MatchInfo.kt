package com.hubtwork.lola.models

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
data class MatchInfo(
    var season: Int,
    var gameId: Long,       // matchId
    var role: String,       // ?
    var champion: Int,
    var queue: Int,
    var lane: String,       // 큐 돌릴 때 선택한 라인
    var timestamp: Long
)

/**
 * response about "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}"
 */

data class MatchDetail (



    var teams: ArrayList<TeamInfo>,                             // 팀별 요약
    var participants: ArrayList<MatchParticipantDetail>,        // 소환사 별 게임 내 디테일 정보
    var participantIdentities: ArrayList<MatchParticipant>      // 소환사 관련 간략 정보 ( 소환사명 아이콘 등 )

)

/**
 *  DTO for teamInfo
 */
data class TeamInfo(
    var teamID : Int, // 100 : Blue, 200 : Red
    var win: String,  // Win : 승리, Fail : 패배

    var firstBlood: Boolean,// 퍼블 여부
    var firstTower: Boolean, // 포블 여부
    var firstInhibitor: Boolean,    // 첫 억제기 파괴 여부
    var firstBaron: Boolean, // 첫 바론 여부
    var firstDragon: Boolean,   // 첫 용 여부
    var firstRiftHerald: Boolean, // 첫 전령 여부

    var towerKills: Int,        // 타워 철거 갯수
    var inhibitorKills: Int,    // 억제기 파괴 갯수
    var baronKills: Int,        // 바론 처치 횟수
    var dragonKills: Int,       // 용 처치 회수
    var riftHeraldKills: Int,   // 전령 처치 횟수
    // var dominionVictoryScore: Int, // < 도미니언 게임 관련 > 도미니언 결과 점수
    // var vilemawKills: Int,  // < 도미니언 게임 관련 > Vilemaw 처치 횟수

    var Bans: ArrayList<BanCard>
)

data class BanCard(
    var pickTurn: Int,
    var championId: Int
)

/**
 *  DTO for participant Detail
 */

data class MatchParticipantDetail (
    var participantId: Int
)

/**
 *  DTO for MathInfo
 */
data class MatchInfoDetail (


    var participants: ArrayList<MatchParticipant>

)

data class MatchParticipant (
    var participantId: Int,
    var playerInfo: MatchPlayer
)

data class MatchPlayer (
    var platformId : String,            // 계정 플랫폼 정보 ( KR 등 )
    var accountId : String,             // Encrypted Account ID
    var profileIcon: Int,               // 프로필 아이콘 ID
    var summonerName : String,          // 소환사 명
    var currentPlatformId : String,     // 플레이 당시 플랫폼 정보 ( KR 등 )
    var currentAccountId : String,      // 플레이 당시 Encrypted Account ID
    var matchHistoryUri: String,        // 매치 기록 URI 인거 같은데.. 잘 모르겠음.
)