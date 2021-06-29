package com.indialone.viewpager2_tablayout_demo.api

import com.indialone.viewpager2_tablayout_demo.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: NewsApiService = getInstance().create(NewsApiService::class.java)

}