package com.maltebucksch.androiddatabindingmvvm.list

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList

/**
 * Created by wanur on 27/09/2017.
 */

public class ListViewModel : ViewModel() {
    val title = ObservableField<String>("Simpsooons")
    val items: ObservableList<ItemViewModel> = ObservableArrayList()

    init {
        listOf("Marge", "List", "Bart", "Homer", "Barney", "Mr. Burns")
                .map { ItemViewModel(it) }.forEach { items.add(it) }
    }
}
