package com.example.cleanarchitecturestudy.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.math.abs

class RefreshLayoutManager(context: Context?, attrs: AttributeSet?) : SwipeRefreshLayout(context!!, attrs) {
    private val mTouchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop
    private var mPrevX = 0f

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mPrevX = MotionEvent.obtain(event).x
            }
            MotionEvent.ACTION_MOVE -> {
                val eventX = event.x
                val moveDiff = abs(eventX - mPrevX)
                if (moveDiff > mTouchSlop) {
                    return false
                }
            }
        }
        return super.onInterceptTouchEvent(event)
    }
}