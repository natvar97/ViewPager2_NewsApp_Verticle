package com.indialone.viewpager2_tablayout_demo.repository

import androidx.annotation.WorkerThread
import com.indialone.viewpager2_tablayout_demo.Constants
import com.indialone.viewpager2_tablayout_demo.api.RetrofitBuilder

class NewsRepository {

    @WorkerThread
    suspend fun getTopHeadlines() = RetrofitBuilder.apiService
        .getTopHeadlines(
            Constants.SOURCE,
            Constants.API_KEY
        )

}