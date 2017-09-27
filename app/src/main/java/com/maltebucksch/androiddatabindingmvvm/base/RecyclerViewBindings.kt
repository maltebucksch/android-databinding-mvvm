package com.maltebucksch.androiddatabindingmvvm.base

import android.databinding.BindingAdapter
import android.databinding.ObservableList
import android.support.annotation.LayoutRes
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by Malte on 25/04/2017.
 */

@BindingAdapter(value = *arrayOf("listItems", "itemLayoutId", "onItemClick"), requireAll = false)
fun <T> setItems(recyclerView: RecyclerView, items: ObservableList<T>, @LayoutRes layoutId: Int?, onItemClickListener: BaseAdapter.OnItemClickListener<T>?) {
    if (layoutId != null) {
        recyclerView.adapter = SingleLayoutItemAdapter<T>(layoutId)
    }
    recyclerView.setHasFixedSize(true)
    setItemsToRecyclerView(recyclerView, items)

    if (onItemClickListener != null) {
        if (recyclerView.adapter !is BaseAdapter<*>) {
            throw ClassCastException("Cannot listen for item clicks on recycler view whose adapter does not extend BaseAdapter")
        }

        (recyclerView.adapter as BaseAdapter<T>).setOnItemClickListener(onItemClickListener)
    }
}

private fun <T> setItemsToRecyclerView(recyclerView: RecyclerView, items: ObservableList<T>) {
    val adapter = recyclerView.adapter ?: throw NullPointerException("Cannot set items to a recycler view whose adapter is null")
    if (adapter !is ItemAdapter<*>) {
        Log.e("LOG", "Cannot set items to a recycler view whose adapter does not extend ItemAdapter")
        return
    }

    val castedAdapter = adapter as ItemAdapter<T>
    castedAdapter.items = items
    castedAdapter.notifyDataSetChanged()
}

@BindingAdapter(value = *arrayOf("layoutManager", "dividersEnabled", "linearLayout"), requireAll = false)
fun setDividersEnabled(recyclerView: RecyclerView, layoutManager: RecyclerView.LayoutManager?, dividersEnabled: Boolean, isLinearLayout: Boolean) {
    if (isLinearLayout) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

    if (layoutManager != null) {
        recyclerView.layoutManager = layoutManager
    }

    if (!dividersEnabled) {
        return
    }
    val dividerItemDecoration = DividerItemDecoration(recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation)
    recyclerView.addItemDecoration(dividerItemDecoration)
}
