package com.maltebucksch.androiddatabindingmvvm.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Malte on 25/04/2017.
 */

abstract class BaseAdapter<out T> : RecyclerView.Adapter<BaseViewHolder>() {
    private var onItemClickListener: OnItemClickListener<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder,
                                  position: Int) {
        val item = getObjForPosition(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClickListener?.onItemClick(item) }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): T

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T)
    }
}

