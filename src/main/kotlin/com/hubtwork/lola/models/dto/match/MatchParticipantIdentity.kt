package com.hubtwork.lola.models.dto.match

/**
 *  DTO for Match ParticipantIdentity
 *
 *      Original Resource Format
 *          - ParticipantIdentity
 *              - participantId
 *              - player
 *                  - player_details ( vars )
 *
 *      Remapping Format    ( Reduction for Managing Efficiently )
 *          - MatchParticipantIdentity
 *              - participantId
 *              - player_details ( vars )
 */
data class MatchParticipantIdentity(
    var participantId: Int,

    // originally in
    var platformId : String,            // 계정 플랫폼 정보 ( KR 등 )
    var accountId : String,             // Encrypted Account ID
    var profileIcon: Int,               // 프로필 아이콘 ID
    var summonerName : String,          // 소환사 명
    var currentPlatformId : String,     // 플레이 당시 플랫폼 정보 ( KR 등 )
    var currentAccountId : String,      // 플레이 당시 Encrypted Account ID
    var matchHistoryUri: String,        // 매치 기록 URI 인거 같은데.. 잘 모르겠음.
)