package com.fuka.livedata

import android.bluetooth.BluetoothDevice
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    val currentNames: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }


    fun print() { Log.d("LD fuka", currentNames.value.toString()) }
    fun add() {
        val v = listOf<String>("Hello ", "there")
        currentNames.value = v
    }
}