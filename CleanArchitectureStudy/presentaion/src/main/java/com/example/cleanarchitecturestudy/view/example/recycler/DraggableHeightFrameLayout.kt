package com.example.cleanarchitecturestudy.view.example.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class DraggableFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    var dragHandle: View? = null

    // targetRecyclerView가 설정되어 있으면, 해당 RecyclerView의 paddingBottom을 translationY에 맞게 조절합니다.
    var targetRecyclerView: RecyclerView? = null

    // 드래그 가능 여부를 제어하는 플래그
    var isDragEnabled = true
        set(value) {
            field = value
            // 드래그가 비활성화되면 현재 진행중인 드래그 작업도 중단
            if (!value) {
                isDragging = false
            }
        }

    // 터치 시작 시의 좌표와 translationY, 그리고 targetRecyclerView의 원래 paddingBottom을 저장합니다.
    private var initialTouchY = 0f
    private var initialTranslationY = 0f
    private var initialRecyclerPaddingBottom = 0

    // 터치 시작 시 dragHandle 영역 안에서 시작되었는지 여부
    private var isDragging = false

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // 드래그가 비활성화되어 있으면 이벤트 가로채지 않음
        if (!isDragEnabled) return false
        
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                // dragHandle 영역 내의 터치 여부 검사
                dragHandle?.let { handle ->
                    val location = IntArray(2)
                    handle.getLocationOnScreen(location)
                    val left = location[0].toFloat()
                    val top = location[1].toFloat()
                    val right = left + handle.width
                    val bottom = top + handle.height
                    if (event.rawX in left..right && event.rawY in top..bottom) {
                        isDragging = true
                        initialTouchY = event.rawY
                        initialTranslationY = translationY
                        targetRecyclerView?.let { recyclerView ->
                            initialRecyclerPaddingBottom = recyclerView.paddingBottom
                        }
                        true
                    } else {
                        isDragging = false
                        false
                    }
                } ?: false
            }

            MotionEvent.ACTION_MOVE,
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> isDragging
            else -> super.onInterceptTouchEvent(event)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // 드래그가 비활성화되어 있으면 이벤트 처리하지 않음
        if (!isDragEnabled) return false
        
        if (!isDragging) return super.onTouchEvent(event)
        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> {
                val offset = event.rawY - initialTouchY
                // 새로운 translationY는 initialTranslationY + offset, 단 0 미만으로 내려가지 않도록 클램핑
                val newTranslation = (initialTranslationY + offset).coerceAtLeast(0f)
                translationY = newTranslation
                // offset이 양수(아래로 드래그)인 경우 targetRecyclerView의 paddingBottom 업데이트,
                // offset이 음수(위로 드래그)인 경우 paddingBottom을 0으로 설정
                if (offset >= 0) {
                    targetRecyclerView?.setPadding(
                        targetRecyclerView!!.paddingLeft,
                        targetRecyclerView!!.paddingTop,
                        targetRecyclerView!!.paddingRight,
                        initialRecyclerPaddingBottom + newTranslation.toInt()
                    )
                } else {
                    targetRecyclerView?.setPadding(
                        targetRecyclerView!!.paddingLeft,
                        targetRecyclerView!!.paddingTop,
                        targetRecyclerView!!.paddingRight,
                        0
                    )
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isDragging = false
            }
        }
        return true
    }
}