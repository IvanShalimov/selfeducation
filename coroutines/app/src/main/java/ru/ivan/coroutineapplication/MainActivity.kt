package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Курс по корутинам был взят здесь: https://startandroid.ru/ru/courses/kotlin.html
 */
class MainActivity : AppCompatActivity() {

    private var formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
    private val scope:CoroutineScope = CoroutineScope(Job())
    lateinit var cancelableJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
        scope.cancel()
    }

    /* Обработчик нажатия для кнопки с id="@+id/button" */
    fun firstTry(view: View) {

        scope.launch {
            delay(10000)
            this.launch {
                delay(1000)
                launch {
                    delay(5000)
                    Log.d(TAG,"third coroutine "+hashCode())
                }
                Log.d(TAG,"second coroutine "+hashCode())
            }
            Log.d(TAG, "first coroutine "+hashCode())
        }

        val job = scope.launch {
            Log.d(TAG, "scope = $this")
        }
        Log.d(TAG, "job = $job")
    }

    /* Обработчик нажатия для кнопки с id="@+id/lesson_eight_run" */
    fun onRun(view:View) {
        log("onRun, start")
        scope.launch {
            log("coroutine start")
            delay(1000)
            log("coroutine end")
        }

        log("onRun, middle")

        scope.launch {
            log("coroutine2 start")
            delay(1500)
            log("coroutine2 end")
        }

        cancelableJob = scope.launch {
            log("coroutine3 start")
            var x = 0
            while (x < 5 && isActive) {
                //Из-за этой функции(suspend под капотом проверяет флаг) проверка флага не нужна, нужно для  TimeUnit.MILLISECONDS.sleep(1000)
                delay(1000)
                log("coroutine, x = ${x++}, isActive = $isActive")
            }
            log("coroutine3 end")
        }

        log("onRun, end")
    }

    /* Обработчик нажатия для кнопки с id="@+id/lesson_eight_cancel" */
    fun onCancel(view:View) {
        log("onCancel")
        cancelableJob.cancel()
    }

    /*Метод с логами для урока # 8*/
    private fun log(text:String) {
        Log.d(TAG, "${formatter.format(Date())} $text [${Thread.currentThread().name}]")
    }

    companion object {
        private const val TAG = "Ivan"
    }
}