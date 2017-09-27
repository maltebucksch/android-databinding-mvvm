package com.maltebucksch.androiddatabindingmvvm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by wanur on 27/09/2017.
 */

public class ListViewModel : ViewModel() {
    val title = ObservableField<String>("Simpsooons");
}
