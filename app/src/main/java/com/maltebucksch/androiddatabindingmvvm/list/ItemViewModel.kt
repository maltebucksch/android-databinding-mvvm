package com.maltebucksch.androiddatabindingmvvm.list

import android.databinding.ObservableField

/**
 * Created by wanur on 27/09/2017.
 */

class ItemViewModel(title: String) {
   val title = ObservableField <String>()

   init {
      this.title.set(title)
   }

}
