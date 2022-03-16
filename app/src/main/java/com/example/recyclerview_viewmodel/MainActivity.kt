package com.example.recyclerview_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_viewmodel.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel : AndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val adapter = ItemAdapter()
        findViewById<RecyclerView>(R.id.rv_item).adapter = adapter

        (myViewModel as MainActivityViewModel).getListUsers().observe(this, Observer {
            it?.let {
                adapter.refreshUsers(it)
            }
        })
    }
}