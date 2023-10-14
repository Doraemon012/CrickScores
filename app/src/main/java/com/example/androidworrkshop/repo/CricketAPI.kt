package com.example.androidworrkshop.repo

import com.example.androidworrkshop.model.MatchInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CricketAPI {

    @Headers(
        "X-RapidAPI-Key:045e586fe2msh853ce575737549fp199bebjsnab82dcbfafbe",
        "X-RapidAPI-Host:cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("series/v1/6732")
    suspend fun getMatchList(): Response<MatchInfo>
}