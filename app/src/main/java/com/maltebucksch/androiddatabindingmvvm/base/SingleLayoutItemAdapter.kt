package com.maltebucksch.androiddatabindingmvvm.base

import android.support.annotation.LayoutRes

/**
 * Created by Malte on 20/06/2017.
 */

class SingleLayoutItemAdapter<T>(@LayoutRes private val layoutId: Int) : ItemAdapter<T>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}
