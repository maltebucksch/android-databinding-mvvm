package com.maltebucksch.androiddatabindingmvvm.base

import android.support.v7.app.AppCompatActivity
import com.maltebucksch.androiddatabindingmvvm.R
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes


/**
 * Created by Malte Bucksch on 06/10/2017.
 */
abstract class BaseActivity: AppCompatActivity() {
    @LayoutRes open protected val layoutId: Int = R.layout.base_activity
    @IdRes open protected val contentFrameId: Int = R.id.contentFrame
    open protected val enableAutoInflate: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (enableAutoInflate) setContentView(layoutId)
    }
}