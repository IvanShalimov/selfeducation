package ru.ivan.coroutineflowapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
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

    fun `L-O-V_E_joke`() {
        val flow = listOf("C", "Т", "Р", "ИМ").asFlow()
        viewModelScope.launch {
            flow.collect { letter ->
                Log.d("Ivan", "${STREAM.getByLetter(letter).value}")
                delay(1000)
            }
        }
    }

    enum class STREAM(val value: String) {
        S("Собрания по 2 часа"),
        T("ТЗшка больше не нужна"),
        R("Реквестов много...просто слишком много"),
        IM("Как в Тинькове дизайн им нужен, с ним мы сядем с вами в лужу");

        companion object {
            fun getByLetter(letter: String): STREAM {
                return when (letter) {
                    "C" -> S
                    "Т" -> T
                    "Р" -> R
                    "ИМ" -> IM
                    else -> S
                }
            }
        }

    }
}