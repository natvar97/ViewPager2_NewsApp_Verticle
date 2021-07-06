package com.indialone.viewpager2_tablayout_demo

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ZoomAnimationViewPager2  : ViewPager2.PageTransformer {

    private val min_scale = 0.7f
    private val min_alpha = 0.5f

    override fun transformPage(page: View, position: Float) {

        val pageWidth = page.width
        val pageHeight = page.height

        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 1) {
            val scaleFactor = Math.max(min_scale, 1 - Math.abs(position))
            val verticalMargin = pageHeight * (1 - scaleFactor) / 2
            val horizontalMargin = pageWidth * (1 - scaleFactor) / 2

            if (position < 0) {
                page.translationX = horizontalMargin - verticalMargin / 2
            } else {
                page.translationX = -horizontalMargin + verticalMargin / 2
            }

            page.scaleX = scaleFactor
            page.scaleY = scaleFactor

            page.alpha = min_alpha + (scaleFactor - min_scale) / (1 - min_scale) * (1 - min_alpha)

        } else {
            page.alpha = 0f
        }

    }
}