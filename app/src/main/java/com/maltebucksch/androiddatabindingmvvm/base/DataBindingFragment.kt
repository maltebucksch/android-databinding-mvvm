package com.maltebucksch.androiddatabindingmvvm.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.maltebucksch.androiddatabindingmvvm.BR
import kotlin.reflect.KClass

/**
 * Created by wanur on 08/08/2017.
 */
abstract class DataBindingFragment<VM : ViewModel, B : ViewDataBinding> : Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(viewModelClass.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<B>(inflater!!, layout, container, false)
        binding.setVariable(BR.view, this)
        binding.setVariable(BR.viewModel, viewModel)

        return binding.root
    }

    //    java does not allow us to extract the class of a generic type at runtime.
    //    Therefore the subclass needs to actively pass the class via this method
    protected abstract val viewModelClass: KClass<VM>

    protected abstract fun createViewModel(): VM?

    @get:LayoutRes protected abstract val layout: Int

    inner class ViewModelFactory : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
            return createViewModel() as T
        }

    }
}
