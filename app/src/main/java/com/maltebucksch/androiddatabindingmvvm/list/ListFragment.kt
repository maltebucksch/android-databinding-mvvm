package com.maltebucksch.androiddatabindingmvvm.list

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.widget.Toast
import com.maltebucksch.androiddatabindingmvvm.R
import com.maltebucksch.androiddatabindingmvvm.base.DataBindingFragment
import com.maltebucksch.androiddatabindingmvvm.databinding.FragmentListBinding
import com.maltebucksch.androiddatabindingmvvm.detail.DetailActivity

/**
 * Created by wanur on 27/09/2017.
 */
public class ListFragment: DataBindingFragment<ListViewModel, FragmentListBinding>() {
    override val viewModelClass = ListViewModel::class
    override val layout = R.layout.fragment_list
    override fun createViewModel(): ListViewModel = ListViewModel()

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    fun onItemClicked(item: ItemViewModel){
        activity.startActivity(Intent(activity,DetailActivity::class.java).putExtra(DetailActivity.KEY_TITLE,item.title.get()))
    }
}