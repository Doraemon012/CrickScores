package com.example.androidworrkshop.repo

import javax.inject.Inject

class CricketRepo @Inject constructor(private val CricketAPI: CricketAPI) {

    suspend fun getMatchList() =CricketAPI.getMatchList()

    suspend fun getMatchScore(id: String)=CricketAPI.getMatchScore(id)

}