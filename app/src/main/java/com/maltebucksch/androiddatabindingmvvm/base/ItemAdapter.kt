package com.maltebucksch.androiddatabindingmvvm.base

/**
 * Created by Malte on 27/04/2017.
 */

abstract class ItemAdapter<T> : BaseAdapter<T> {
    var items: List<T>? = null
        get
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    constructor() {}

    constructor(items: List<T>) {
        this.items = items
    }

    override fun getObjForPosition(position: Int): T {
        return items!![position]
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }
}
