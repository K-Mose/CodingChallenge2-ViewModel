package com.example.codingchallenge2_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.codingchallenge2_viewmodel.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = MainActivityViewModelFactory(111)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.apply {
            tvSum.text = viewModel.getCurrentNumber().toString()
            btnAdd.setOnClickListener {
                etNumber.text.also {
                    if (it.isNullOrEmpty()) {
                        Toast.makeText(this@MainActivity, "Please put some number and try Again.", Toast.LENGTH_SHORT).show()
                    } else {
                        tvSum.text = viewModel.addNumber(it.toString().toInt()).toString()
                    }
                }
            }
        }
    }
}