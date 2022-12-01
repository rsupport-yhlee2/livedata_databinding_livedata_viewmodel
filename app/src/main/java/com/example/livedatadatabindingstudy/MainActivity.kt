package com.example.livedatadatabindingstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.livedatadatabindingstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val liveText: MutableLiveData<String> = MutableLiveData()
    var value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
        }
        liveText.value = "hello"
        liveText.observe(this){
            binding.text.text = it
        }
        binding.plus.setOnClickListener {
            value += 1
            liveText.value = "$value"
        }
        binding.minus.setOnClickListener {
            value -= 1
            liveText.value = "$value"
        }
    }
}