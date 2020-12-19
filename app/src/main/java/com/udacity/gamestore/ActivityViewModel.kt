package com.udacity.gamestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    init {
        Log.i("test", "ActivityViewModel created")
    }

    private lateinit var _username: String

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn : LiveData<Boolean>
        get() = _isLoggedIn

    fun login(username: String){
        Log.i("test", "ActivityViewModel login $username")
        _username = username
        _isLoggedIn.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("test", "ActivityViewModel onCleared")
    }
}