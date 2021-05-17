package ru.ivan.practicecoroutineapplication

import android.util.Log
import androidx.lifecycle.*

class MyServer: LifecycleObserver {

    private val data: MutableLiveData<String> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.d("Ivan","start")
    }

    fun auth() {
        data.postValue("Success!")
    }

    fun subscribeDigital(): LiveData<Int> = Transformations.map(data) {
        if(it.equals("Success")){
            1
        } else {
            0
        }
    }

    fun subscribe() = data

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun notifyEndSession() {
        Log.d("Ivan","end")
    }

}