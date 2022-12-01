package com.example.livedatadatabindingstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.livedatadatabindingstudy.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger("onCreate")
        //viewModel = MainViewModel() 작동안됨
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.liveText.observe(this) {
            binding.text.text = it
        }
    }

    private fun logger(message: String) {
        Log.e(TAG, message)
    }

    override fun onPause() {
        super.onPause()
        logger("onPause")
    }

    override fun onResume() {
        super.onResume()
        logger("onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger("onDestroy")
    }

    override fun onStart() {
        super.onStart()
        logger("onStart")
    }

    override fun onStop() {
        super.onStop()
        logger("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logger("onRestart")
    }
}