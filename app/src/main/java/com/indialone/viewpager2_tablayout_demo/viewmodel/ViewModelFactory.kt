package com.indialone.viewpager2_tablayout_demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indialone.viewpager2_tablayout_demo.repository.NewsRepository
import java.lang.IllegalArgumentException

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(NewsRepository()) as T
        }
        throw IllegalArgumentException("Unknown View Model Class found")
    }
}