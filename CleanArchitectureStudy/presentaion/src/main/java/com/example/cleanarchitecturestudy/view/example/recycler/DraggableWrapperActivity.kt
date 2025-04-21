package com.example.cleanarchitecturestudy.view.example.recycler

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.databinding.ActivityDraggableWrapperBinding

class DraggableWrapperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDraggableWrapperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDraggableWrapperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.draggableLayout.dragHandle = binding.handle
        binding.draggableLayout.targetRecyclerView = binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@DraggableWrapperActivity)
            adapter = MyAdapter(generateDummyData())
        }
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