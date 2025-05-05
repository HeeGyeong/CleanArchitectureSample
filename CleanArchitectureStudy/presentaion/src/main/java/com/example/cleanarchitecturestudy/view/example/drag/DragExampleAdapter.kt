package com.example.cleanarchitecturestudy.view.example.drag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.databinding.ItemDragExampleBinding

/**
 * 드래그 예제의 페이징 어댑터
 */
class DragExampleAdapter : PagingDataAdapter<DragExampleItem, DragExampleAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DragExampleItem>() {
            override fun areItemsTheSame(oldItem: DragExampleItem, newItem: DragExampleItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DragExampleItem, newItem: DragExampleItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDragExampleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val binding: ItemDragExampleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DragExampleItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
} 