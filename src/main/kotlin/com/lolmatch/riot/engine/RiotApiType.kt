package com.lolmatch.riot.engine

import com.lolmatch.riot.engine.response.CurrentGameInfoResponse
import com.lolmatch.riot.engine.response.DefaultApiResponse
import com.lolmatch.riot.engine.response.SummonerNameSearchResponse
import java.lang.reflect.Type

enum class RiotApiType(val url: String, val responseType: Type, val msg: String) {
    DEFAULT(
        "",
        DefaultApiResponse::class.java,
        "요청없음"
    ),
    RANK_BY_ENCRYPTED_ID(
        "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}",
        SummonerNameSearchResponse::class.java,
        "암호화된 아이디로 랭크 검색"
    ),
    SUMMONER(
        "/lol/summoner/v4/summoners/by-name/{summonerName}",
        SummonerNameSearchResponse::class.java,
        "소환사명 검색"
    ),
    SUMMONER_BY_ENCRYPTED_ACCOUNT_ID(
        "/lol/summoner/v4/summoners/by-account/{encryptedAccountId}",
        SummonerNameSearchResponse::class.java,
        "암호화된 아이디로 소환사명 검색"
    ),
    CURRENT_GAME_INFO_BY_ENCRYPTED_ACCOUNT_ID(
        "/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}",
        CurrentGameInfoResponse::class.java,
        "암호화된 아이디로 게임데이터 검색"
    );
}