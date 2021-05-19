package ru.ivan.practicecoroutineapplication.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyCustomViewModelFabric(
    private val app: Application,
    private val id: Int
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == MyViewModel::class.java) {
            MyViewModel(app, id) as T
        } else throw RuntimeException("")
    }
}