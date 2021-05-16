package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.resumeWithException

class LessonActivity16 : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson16)
    }

    fun handleClick(view: View) {
        scope.launch {
            val d = async {
                someWork()
            }
            val waitedJob = launch {
                TimeUnit.MILLISECONDS.sleep(1000)
                log("Finish second child job")
            }
            waitedJob.join()
            val result = d.await()
            log("Result: $result")
            cancel()
        }
    }

    suspend fun someWork(): String {
        return suspendCancellableCoroutine { continuation ->
            thread {
                TimeUnit.MILLISECONDS.sleep(5000)
                continuation.resume("Success") {
                    log("Canceled")
                    continuation.resumeWithException(it)
                }
            }
        }
    }

    fun scope(view: View) {

    }

    private suspend fun twoCoroutine(){
        coroutineScope {

        }
    }
}


