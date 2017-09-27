package com.maltebucksch.androiddatabindingmvvm

import android.arch.lifecycle.ViewModelProvider
import com.maltebucksch.androiddatabindingmvvm.base.DataBindingFragment
import com.maltebucksch.androiddatabindingmvvm.databinding.FragmentListBinding
import kotlin.reflect.KClass

/**
 * Created by wanur on 27/09/2017.
 */
public class ListFragment: DataBindingFragment<ListViewModel, FragmentListBinding>() {
    override val viewModelClass = ListViewModel::class
    override val viewModelFactory = null
    override val layout = R.layout.fragment_list

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}