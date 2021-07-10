package com.example.codingchallenge2_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    /*
    LiveData vs MutableLiveData
    Data in a LiveData object are Only readable, not editable
    A MutableLiveData object allows us to change/update its data
     */
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int> //
    get() = total

    init {
            total.value = startingTotal
    }
    fun addNumber(number: Int): Int {
        total.value = (total.value)?.plus(number)
        return total.value!!
    }
}