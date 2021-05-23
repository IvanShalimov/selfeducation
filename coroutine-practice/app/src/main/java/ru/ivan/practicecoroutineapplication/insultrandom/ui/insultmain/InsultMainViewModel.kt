package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.API
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.APIRetrofitImpl

class InsultMainViewModel : ViewModel() {
    private val api:API = APIRetrofitImpl()
    val insult: MutableLiveData<InsultPresentationModel> = MutableLiveData()
    var requestJob: Job? = null

    init {
        Log.d("Ivan","Init view model")
        fetchInsult()
    }

    fun fetchInsult() {
        Log.d("Ivan","fetch insult")
        requestJob?.let {
            if (it.isActive) return
        }
        Log.d("Ivan","can start request")
        requestJob = viewModelScope.launch {
             api.getInsult()?.let {
                 Log.d("Ivan","get result")
                 insult.value = it
             }
        }
    }
}