package ru.ivan.practicecoroutineapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class MyViewModel(application: Application,
                  private val id: Int): AndroidViewModel(application) {

    private val repository:Repository

    init {
        Log.d("Ivan","initViewModel")
        repository = Repository()
        repository.loadData()
    }

    fun getData():LiveData<String> {
        return repository.subscribeData()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Ivan","onClear")
    }
}