package com.example.livedatadatabindingstudy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val liveText: MutableLiveData<String> = MutableLiveData("0")
    var num = 0
    fun plus(){
        Log.e("plus","1")
        num += 1
        liveText.value = num.toString()
    }

    fun minus(){
        num -= 1
        Log.e("minus","1")
        liveText.value = num.toString()
    }
}