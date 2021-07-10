package com.example.codingchallenge2_viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var total = 0
    init {
            total = startingTotal
    }

    fun getCurrentNumber(): Int = total
    fun addNumber(number: Int): Int {
        Log.d("getNumber ::","$number")
        this.total += number
        Log.d("thisNumber ::","${this.total}")
        return this.total
    }
}