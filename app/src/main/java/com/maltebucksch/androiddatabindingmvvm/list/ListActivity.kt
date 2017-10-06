package com.maltebucksch.androiddatabindingmvvm.list

import android.os.Bundle
import com.maltebucksch.androiddatabindingmvvm.R
import com.maltebucksch.androiddatabindingmvvm.base.BaseActivity

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportFragmentManager.findFragmentById(contentFrameId) == null)
            supportFragmentManager.beginTransaction().add(contentFrameId, ListFragment.newInstance()).commit()
    }
}
