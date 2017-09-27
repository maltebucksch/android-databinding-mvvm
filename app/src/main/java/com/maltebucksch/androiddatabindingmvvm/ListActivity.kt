package com.maltebucksch.androiddatabindingmvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.maltebucksch.androiddatabindingmvvm.list.ListFragment

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        if(supportFragmentManager.findFragmentById(R.id.contentFrame) == null){
            supportFragmentManager.beginTransaction().add(R.id.contentFrame, ListFragment.newInstance()).commit()
        }
    }
}
