package com.example.recyclerview_viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_viewmodel.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel : AndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val adapter = ItemAdapter()
        findViewById<RecyclerView>(R.id.rv_item).adapter = adapter

        (myViewModel as MainActivityViewModel).getListUsers().observe(this) {
            it?.let {
                adapter.refreshUsers(it)
            }
        }
    }
}