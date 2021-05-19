package ru.ivan.practicecoroutineapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class Repository {

    private val myData:MutableLiveData<String> = MutableLiveData()
    private val scope: CoroutineScope = CoroutineScope(Job())
    private var i = 0

    fun loadData() {
        scope.launch {
            myData.postValue("${++i}")
            launch {
                delay(5000)
                myData.postValue("${++i}")
            }
            launch {
                delay(10000)
                myData.postValue("${++i}")
            }
            launch {
                delay(15000)
                myData.postValue("${++i}")
            }

        }
    }

    fun subscribeData(): LiveData<String> {
        return myData
    }
}