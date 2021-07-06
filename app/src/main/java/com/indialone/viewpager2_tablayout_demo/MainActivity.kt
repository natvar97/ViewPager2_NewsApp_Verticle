package com.indialone.viewpager2_tablayout_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.indialone.viewpager2_tablayout_demo.model.ArticlesItem
import com.indialone.viewpager2_tablayout_demo.viewmodel.NewsViewModel
import com.indialone.viewpager2_tablayout_demo.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)

        newsViewModel = ViewModelProvider(this, ViewModelFactory()).get(NewsViewModel::class.java)

        newsViewModel.getAllTopHeadlines().observe(this){ newsEntity ->
            viewPager.adapter = ViewPagerAdapter(newsEntity.articles as ArrayList<ArticlesItem>)
            viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
            viewPager.setPageTransformer(ZoomAnimationViewPager2())
        }

    }
}