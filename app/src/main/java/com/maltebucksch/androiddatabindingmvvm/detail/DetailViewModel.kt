package com.maltebucksch.androiddatabindingmvvm.detail

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by Malte Bucksch on 06/10/2017.
 */

class DetailViewModel(title: String) : ViewModel() {
    val title = ObservableField<String>("Simpsooons")
    val notes = ObservableField<String>("")

    init {
        this.title.set(title)
    }

}
