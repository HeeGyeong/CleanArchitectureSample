package com.example.cleanarchitecturestudy.view.rank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ItemRankGoodsBinding
import com.example.domain.model.Ranking

class RankingAdapter() : ListAdapter<Ranking, RankingAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingAdapter.ViewHolder {
        val binding: ItemRankGoodsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_rank_goods,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemRankGoodsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rank: Ranking) {
            binding.rank = rank
            binding.executePendingBindings()
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Ranking>() {
            override fun areContentsTheSame(oldItem: Ranking, newItem: Ranking) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Ranking, newItem: Ranking) =
                oldItem.id == newItem.id
        }
    }
}