package com.maltebucksch.androiddatabindingmvvm.list

import android.widget.Toast
import com.maltebucksch.androiddatabindingmvvm.R
import com.maltebucksch.androiddatabindingmvvm.base.DataBindingFragment
import com.maltebucksch.androiddatabindingmvvm.databinding.FragmentListBinding

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

    fun onItemClicked(){
        Toast.makeText(activity,"Clicked",Toast.LENGTH_SHORT).show()
    }
}