package com.example.codingchallenge2_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.codingchallenge2_viewmodel.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

        // encapsulate LiveData.
        /*
        LiveData는 Observer로 관찰하여 데이터에 변화가 오면
        자동으로 UI를 업데이트 한다.
        연관된 lifecycle에 변화가 생기면 LiveData가 인지하여서
        destory될 때 스스로 clean up 하여 activity나 fragment가 종료될 때
        메모리 누수나 크래쉬가 없다.
         */
        viewModel.totalData.observe(this, Observer { ld ->
            binding.tvSum.text = ld.toString()
        })
        binding.apply {
            btnAdd.setOnClickListener {
                etNumber.text.also {
                    if (it.isNullOrEmpty()) {
                        Toast.makeText(this@MainActivity, "Please put some number and try Again.", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.addNumber(it.toString().toInt())
                    }
                }
            }
        }
    }
}