package com.maltebucksch.androiddatabindingmvvm.base

import android.support.annotation.LayoutRes

/**
 * Created by Malte on 27/04/2017.
 */

class ItemAdapter<T>(@LayoutRes private val layoutId: Int) : BaseAdapter<T>() {
    var items: List<T>? = null
        get
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

    override fun getObjForPosition(position: Int): T {
        return items!![position]
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }
}
