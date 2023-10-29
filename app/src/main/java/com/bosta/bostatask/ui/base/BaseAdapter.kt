package com.bosta.bostatask.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bosta.bostatask.BR

abstract class BaseAdapter<T>(private val listener: BaseInteractionListener) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    private var items = emptyList<T>()
    abstract val layoutId: Int

    open fun setItems(newItems: List<T>) {
        val diffResult =
            DiffUtil.calculateDiff(BaseDiffUtil(items, newItems, ::areSameItem, ::areSameContent))
        items = newItems
        diffResult.dispatchUpdatesTo(this)

    }

    private fun areSameItem(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true
    private fun areSameContent(oldPosition: T, newPosition: T) = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.viewModel, currentItem)
                    setVariable(BR.listener, listener)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}

interface BaseInteractionListener