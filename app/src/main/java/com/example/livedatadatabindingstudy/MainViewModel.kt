package com.example.livedatadatabindingstudy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val liveText: MutableLiveData<String> = MutableLiveData("0")
    val plusEnabled : MutableLiveData<Boolean> = MutableLiveData(true)
    val minusEnabled : MutableLiveData<Boolean> = MutableLiveData(true)
    var num = 0
    fun plus(){
        num += 1
        liveText.value = num.toString()
        plusEnabled.value = num < 3
        minusEnabled.value = num > -3
    }

    fun minus(){
        num -= 1
        liveText.value = num.toString()
        minusEnabled.value = num > -3
        plusEnabled.value = num < 3
    }
}