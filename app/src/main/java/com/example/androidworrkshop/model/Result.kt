package com.example.androidworrkshop.model

data class Result(
    var resultType: String,
    var winByInnings: Boolean,
    var winByRuns: Boolean,
    var winningMargin: Int,
    var winningTeam: String,
    var winningteamId: Int
)