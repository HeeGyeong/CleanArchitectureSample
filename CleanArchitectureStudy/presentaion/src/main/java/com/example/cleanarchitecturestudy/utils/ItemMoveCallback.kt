package com.example.cleanarchitecturestudy.utils

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturestudy.view.search.MovieAdapter


class ItemMoveCallback(private val mAdapter: ItemTouchInterface) :
    ItemTouchHelper.Callback() {

    override fun isLongPressDragEnabled() = true
    override fun isItemViewSwipeEnabled() = false
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {}

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0)
    }

    override fun onMove(
        recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        mAdapter.onRowMoved(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSelectedChanged(
        viewHolder: RecyclerView.ViewHolder?,
        actionState: Int
    ) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder is MovieAdapter.ViewHolder) {
                val itemViewHolder: MovieAdapter.ViewHolder = viewHolder
                mAdapter.onRowSelected(itemViewHolder)
            }
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) {
        super.clearView(recyclerView, viewHolder)
        if (viewHolder is MovieAdapter.ViewHolder) {
            val itemViewHolder: MovieAdapter.ViewHolder = viewHolder
            mAdapter.onRowClear(itemViewHolder)
        }
    }

    interface ItemTouchInterface {
        fun onRowMoved(fromPosition: Int, toPosition: Int)
        fun onRowSelected(itemViewHolder: MovieAdapter.ViewHolder?)
        fun onRowClear(itemViewHolder: MovieAdapter.ViewHolder?)
    }
}