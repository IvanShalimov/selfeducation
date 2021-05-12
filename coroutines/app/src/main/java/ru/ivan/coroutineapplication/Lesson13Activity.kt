package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class Lesson13Activity : AppCompatActivity() {

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        log("$exception was handled in Coroutine_${context[CoroutineName]?.name}")
    }
    private val coroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default + exceptionHandler)
    private val ioCoroutineScope = CoroutineScope(Job() + Dispatchers.IO + exceptionHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson13)
    }

    fun runException(view: View) {
        /*
        //1
        coroutineScope.launch {
            try {
                Integer.parseInt("a")
            } catch (e: Exception ) {
                log("Exception!!!")
            }
        }*/

        /*
        //2
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            log("Exception: $exception")
        }
        coroutineScope.launch(exceptionHandler) {
            Integer.parseInt("a")
        }*/

        coroutineScope.launch(exceptionHandler) {
            TimeUnit.MILLISECONDS.sleep(1000)
            Integer.parseInt("a")
        }
        coroutineScope.launch(exceptionHandler) {
            repeat(5) {
                TimeUnit.MILLISECONDS.sleep(300)
                log("second coroutine is active - $isActive")
            }
        }
    }

    fun runException2(view: View) {
        ioCoroutineScope.launch(CoroutineName("1")) {
            launch(CoroutineName("1_1")) {
                TimeUnit.MILLISECONDS.sleep(1000)
                log("exception")
                Integer.parseInt("a") }
            launch(CoroutineName("1_2")) {
                repeatIsActive()
            }
            repeatIsActive()
        }

        ioCoroutineScope.launch(CoroutineName("2")) {
            launch(CoroutineName("2_1")) {
                repeatIsActive()
            }
            launch(CoroutineName("2_2")) {
                repeatIsActive()
            }
            repeatIsActive()
        }
    }

    fun CoroutineScope.repeatIsActive() {
        repeat(5) {
            log("Coroutine_${coroutineContext[CoroutineName]?.name} isActive $isActive")
        }
    }

}