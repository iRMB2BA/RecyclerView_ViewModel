package com.example.recyclerview_viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.recyclerview_viewmodel.data.ItemData
import com.example.recyclerview_viewmodel.model.Item

class MainActivityViewModel(application: Application) : AndroidViewModel(application){
    var userList : MutableLiveData<List<Item>> = MutableLiveData()


    init {
        userList.value = ItemData.getUsers()
    }

    fun getListUsers() = userList

}