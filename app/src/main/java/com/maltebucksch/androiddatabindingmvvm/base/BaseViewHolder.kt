package com.maltebucksch.androiddatabindingmvvm.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

import com.android.databinding.library.baseAdapters.BR

/**
 * Created by Malte on 25/04/2017.
 */

class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: Any?) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
    }
}
