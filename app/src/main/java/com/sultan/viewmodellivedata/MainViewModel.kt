package com.sultan.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel(){
    var number = 0
    val currentNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val currentBoolean : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


}



