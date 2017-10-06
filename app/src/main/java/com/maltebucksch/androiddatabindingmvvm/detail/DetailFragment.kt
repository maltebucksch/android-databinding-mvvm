package com.maltebucksch.androiddatabindingmvvm.detail

import android.os.Bundle
import android.widget.Toast
import com.maltebucksch.androiddatabindingmvvm.R
import com.maltebucksch.androiddatabindingmvvm.base.DataBindingFragment
import com.maltebucksch.androiddatabindingmvvm.databinding.FragmentDetailBinding
import com.maltebucksch.androiddatabindingmvvm.databinding.FragmentListBinding
import com.maltebucksch.androiddatabindingmvvm.list.ListViewModel

/**
 * Created by wanur on 27/09/2017.
 */
public class DetailFragment : DataBindingFragment<DetailViewModel, FragmentDetailBinding>() {
    override val viewModelClass = DetailViewModel::class
    override val layout = R.layout.fragment_detail
    override fun createViewModel(): DetailViewModel = DetailViewModel(arguments.getString(DetailActivity.KEY_TITLE))

    companion object {
        fun newInstance(title: String): DetailFragment {
            val detailFragment = DetailFragment()
            val arguments = Bundle()
            arguments.putString(DetailActivity.KEY_TITLE,title)
            detailFragment.arguments = arguments
            return detailFragment
        }
    }
}