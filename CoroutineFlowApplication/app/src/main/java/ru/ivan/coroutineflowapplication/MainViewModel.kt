package ru.ivan.coroutineflowapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var currentJob: Job? = null

    fun count(callback: (Int) -> Unit) {
        currentJob?.let {
            if (it.isActive) return
        }

        currentJob = viewModelScope.launch {
            getFlowCounter().collect { number ->
                callback(number)
            }
        }
    }

    private fun getFlowCounter() = flow {
        for (i in 1..10) {
            kotlinx.coroutines.delay(1000)
            emit(i)
        }
    }
}