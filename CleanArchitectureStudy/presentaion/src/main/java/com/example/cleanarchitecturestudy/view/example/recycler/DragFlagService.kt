package com.example.cleanarchitecturestudy.view.example.recycler

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper

class DragFlagService : Service() {
    
    private val binder = DragFlagBinder()
    private val handler = Handler(Looper.getMainLooper())
    private var isDragEnabled = true
    
    // 드래그 상태 변경 리스너
    private val listeners = mutableListOf<(Boolean) -> Unit>()
    
    // 5초마다 Flag 값을 변경하는 Runnable
    private val flagToggleRunnable = object : Runnable {
        override fun run() {
            isDragEnabled = !isDragEnabled
            // 모든 리스너에게 상태 변경 알림
            listeners.forEach { it(isDragEnabled) }
            // 다음 5초 후 다시 실행
            handler.postDelayed(this, FLAG_TOGGLE_INTERVAL)
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        // 서비스 시작 시 Runnable 시작
        handler.post(flagToggleRunnable)
    }
    
    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // 서비스 종료 시 Runnable 제거
        handler.removeCallbacks(flagToggleRunnable)
    }
    
    // 리스너 추가
    fun addDragStateListener(listener: (Boolean) -> Unit) {
        listeners.add(listener)
        // 추가 즉시 현재 상태 전달
        listener(isDragEnabled)
    }
    
    // 리스너 제거
    fun removeDragStateListener(listener: (Boolean) -> Unit) {
        listeners.remove(listener)
    }
    
    // 서비스 바인딩을 위한 Binder 클래스
    inner class DragFlagBinder : Binder() {
        fun getService(): DragFlagService = this@DragFlagService
    }
    
    companion object {
        private const val FLAG_TOGGLE_INTERVAL = 5000L // 5초
    }
} 