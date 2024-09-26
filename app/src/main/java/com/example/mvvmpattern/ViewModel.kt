package com.example.mvvmpattern

import androidx.lifecycle.MutableLiveData

class ViewModel {
    var toastMessage = MutableLiveData<Int>()
    var checkPasswordMessage = MutableLiveData<Boolean>(false)

    val model = Model()

    fun clickNumber(i : Int){
        toastMessage.value = i

        model.inputPassword(i)

        if(model.password.size == 4 && model.checkPassword()){
            checkPasswordMessage.value = true
        }
    }
}