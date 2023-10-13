package com.example.androidworrkshop.di

import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class NetworkModule {


    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient() : OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()

        val requestInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addNetworkInterceptor(requestInterceptor)

        return builder.build()
    }

//    @Singleton
//    @Provides
//    fun providesSevayuAPI(retrofit: Retrofit): ImageAPI {
//        return retrofit.create(ImageAPI::class.java)
//    }

}