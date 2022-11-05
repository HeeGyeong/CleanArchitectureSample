package com.example.cleanarchitecturestudy.view.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ItemMovieBinding
import com.example.cleanarchitecturestudy.utils.ItemMoveCallback
import com.example.domain.model.Movie
import com.orhanobut.logger.Logger
import java.util.*
import kotlin.collections.ArrayList

class MovieAdapter(private val itemClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(
        diffUtil
    ), ItemMoveCallback.ItemTouchInterface {

    private var movieList: ArrayList<Movie> = ArrayList()

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

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        Logger.d("onRowMoved :: $fromPosition > $toPosition")

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(movieList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(movieList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(itemViewHolder: ViewHolder?) {
        Logger.d("onRowSelected")
        itemViewHolder!!.rowView!!.setBackgroundColor(
            ContextCompat.getColor(
                itemViewHolder.context!!,
                R.color.bright_grey
            )
        )
    }

    override fun onRowClear(itemViewHolder: ViewHolder?) {
        Logger.d("onRowClear")
        itemViewHolder!!.rowView!!.setBackgroundColor(
            ContextCompat.getColor(
                itemViewHolder.context!!,
                R.color.white
            )
        )
    }

    fun setMovieList(movieList: ArrayList<Movie>) {
        this.movieList = movieList
    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var context: Context? = null
        var rowView: View? = null

        fun bind(movie: Movie) {
            context = binding.root.context
            rowView = binding.movieItemContainer
            binding.movie = movie
            // 데이터 변경 시 binding 을 예약하지 않고 '즉시' 반영한다.
            binding.executePendingBindings()
        }
    }

    /**
     * diff object
     *
     * 서로 같은 아이템인지 판단하기 위한 조건을 직접 추가한다.
     * title 을 사용하여 같은 아이템인지 여부를 판단하도록 하였다.
     */
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Movie>() {
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.title == newItem.title
        }
    }
}