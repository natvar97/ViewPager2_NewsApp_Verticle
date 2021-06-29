package com.indialone.viewpager2_tablayout_demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.viewpager2_tablayout_demo.model.NewsEntity
import com.indialone.viewpager2_tablayout_demo.repository.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val newsList = MutableLiveData<NewsEntity>()

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getTopHeadlines()
                    }
                    newsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getAllTopHeadlines() : LiveData<NewsEntity> {
        return newsList
    }

}