package com.example.cleanarchitecturestudy.view.example.blur

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.databinding.ItemBlurSampleBinding

class BlurSampleAdapter : RecyclerView.Adapter<BlurSampleAdapter.ViewHolder>() {

    private val items = mutableListOf<BlurSampleItem>()

    fun setItems(newItems: List<BlurSampleItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBlurSampleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemBlurSampleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BlurSampleItem) {
            binding.text1.text = item.text1
            binding.text2.text = item.text2
        }
    }

    data class BlurSampleItem(
        val text1: String,
        val text2: String
    )
} 