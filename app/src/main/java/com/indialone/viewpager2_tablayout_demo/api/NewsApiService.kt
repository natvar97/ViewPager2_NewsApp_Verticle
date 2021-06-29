package com.indialone.viewpager2_tablayout_demo.api

import com.indialone.viewpager2_tablayout_demo.model.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String
    ) : NewsEntity

}