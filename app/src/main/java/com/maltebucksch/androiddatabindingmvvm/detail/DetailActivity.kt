package com.maltebucksch.androiddatabindingmvvm.detail

import android.os.Bundle
import com.maltebucksch.androiddatabindingmvvm.base.BaseActivity
import com.maltebucksch.androiddatabindingmvvm.list.ListFragment

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportFragmentManager.findFragmentById(contentFrameId) == null)
            supportFragmentManager.beginTransaction().add(contentFrameId, DetailFragment.newInstance(intent.getStringExtra(KEY_TITLE))).commit()
    }

    companion object {
        const val KEY_TITLE = "KEY_TITLE"
    }
}