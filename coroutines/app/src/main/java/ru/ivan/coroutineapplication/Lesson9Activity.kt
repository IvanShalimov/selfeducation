package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class Lesson9Activity : AppCompatActivity() {

    private val scope: CoroutineScope = CoroutineScope(Job())
    lateinit var lazyJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson9)
    }

    fun onRun1(view: View) {
        scope.launch {
            log("parent coroutine start")
            val job = launch {
                log("child coroutine start")
                TimeUnit.MILLISECONDS.sleep(1000)
                log("child coroutine end")
            }
            job.join()
            log("parent coroutine end")
        }
        log("onRun, start")
        lazyJob = scope.launch(start = CoroutineStart.LAZY) {
            log("coroutine start")
            TimeUnit.MILLISECONDS.sleep(1000)
            log("coroutine end")
        }
        log("onRun, end")
    }

    fun onRun2(view: View) {
        log("onRun2, start")
        lazyJob.start()
        log("onRun2, end")
    }

    fun onRun3(view: View) {
        scope.launch {
            log("parent coroutine start")
            val deferred = async {
                log("child coroutine start")
                TimeUnit.MILLISECONDS.sleep(1000)
                log("child coroutine end")
                "async result"
            }
            log("parent coroutine waits until child returns result")
            val result = deferred.await()
            log("parents coroutine, child returns: $result")
            log("parent coroutine ent")
        }
    }

    fun onRun4(view: View) {
        scope.launch {
            log("parent coroutine start")
            val data = async { getData() }
            val data2 = async { getData2() }
            val result = "${data.await()} ${data2.await()}"
            log("parent coroutine, child returns: $result")
            log("parent coroutine end")
        }
    }

    private suspend fun getData():String {
        TimeUnit.MILLISECONDS.sleep(1000)
        return "data"
    }

    private suspend fun getData2():String {
        TimeUnit.MILLISECONDS.sleep(1500)
        return "data2"
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    companion object {
        private const val TAG = "Ivan"
    }
}