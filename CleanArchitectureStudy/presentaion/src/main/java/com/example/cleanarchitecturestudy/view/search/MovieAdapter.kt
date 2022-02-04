package com.example.cleanarchitecturestudy.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ItemMovieBinding
import com.example.domain.model.Movie

class MovieAdapter(private val itemClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(
        diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                itemClick(getItem(position))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            // 데이터 변경 시 binding 을 예약하지 않고 즉시 반영한다.
            binding.executePendingBindings()
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Movie>() {
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.title == newItem.title
        }
    }
}