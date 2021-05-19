package ru.ivan.practicecoroutineapplication.sharefragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val data: MutableLiveData<String> = MutableLiveData("dssdsd")
    private val flag: MutableLiveData<Int> = MutableLiveData(-1)

    fun setValue(value:String) {
        data.value = value
    }

    fun subscribeData(): LiveData<String>{
        return Transformations.map(data) {
            "Your result is: $it"
        }
    }

    fun setFlag(value: Int) {
        flag.value = value
    }

    fun subscribeFlag(): LiveData<Int> {
        return flag
    }

}