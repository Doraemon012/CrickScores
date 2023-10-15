package com.example.androidworrkshop.model

data class Miniscore(
    var batTeam: BatTeam,
    var batsmanNonStriker: BatsmanNonStriker,
    var batsmanStriker: BatsmanStriker,
    var bowlerNonStriker: BowlerNonStriker,
    var bowlerStriker: BowlerStriker,
    var currentRunRate: Double,
    var event: String,
    var inningsId: Int,
    var lastWicket: String,
    var lastWicketScore: Int,
    var latestPerformance: List<Any>,
    var matchScoreDetails: MatchScoreDetails,
    var matchUdrs: MatchUdrs,
    var overSummaryList: List<Any>,
    var overs: Double,
    var partnerShip: PartnerShip,
    var ppData: PpData,
    var recentOvsStats: String,
    var remRunsToWin: Int,
    var requiredRunRate: Double,
    var responseLastUpdated: Int,
    var target: Int
)