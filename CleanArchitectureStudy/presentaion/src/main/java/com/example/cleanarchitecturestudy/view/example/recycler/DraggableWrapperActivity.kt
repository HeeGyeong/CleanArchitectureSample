package com.example.cleanarchitecturestudy.view.example.recycler

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.databinding.ActivityDraggableWrapperBinding

class DraggableWrapperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDraggableWrapperBinding
    
    // 서비스 참조
    private var dragFlagService: DragFlagService? = null
    private var isBound = false
    
    // 드래그 상태 변경 리스너
    private val dragStateListener: (Boolean) -> Unit = { isEnabled ->
        binding.draggableLayout.isDragEnabled = isEnabled
        runOnUiThread {
            val stateText = if (isEnabled) "드래그 활성화" else "드래그 비활성화"
            Toast.makeText(this, stateText, Toast.LENGTH_SHORT).show()
        }
    }
    
    // 서비스 연결을 관리하는 ServiceConnection
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as DragFlagService.DragFlagBinder
            dragFlagService = binder.getService()
            isBound = true
            
            // 서비스에 리스너 등록
            dragFlagService?.addDragStateListener(dragStateListener)
        }
        
        override fun onServiceDisconnected(name: ComponentName?) {
            dragFlagService = null
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDraggableWrapperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.draggableLayout.dragHandle = binding.handle
        binding.draggableLayout.targetRecyclerView = binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@DraggableWrapperActivity)
            adapter = MyAdapter(generateDummyData())
        }
        
        // 서비스 시작 및 바인딩
        startAndBindService()
    }
    
    override fun onDestroy() {
        // 서비스에서 리스너 제거 및 언바인딩
        if (isBound) {
            dragFlagService?.removeDragStateListener(dragStateListener)
            unbindService(serviceConnection)
            isBound = false
        }
        super.onDestroy()
    }
    
    private fun startAndBindService() {
        // 서비스 시작
        val intent = Intent(this, DragFlagService::class.java)
        startService(intent)
        // 서비스에 바인딩
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }
    
    private fun generateDummyData(): List<String> =
        List(50) { "Item ${it + 1}" }
}


class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.VH>() {

    inner class VH(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val tv = TextView(parent.context).apply {
            layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            setPadding(16, 16, 16, 16)
            setTextColor(ContextCompat.getColor(context, android.R.color.black))
        }
        return VH(tv)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}