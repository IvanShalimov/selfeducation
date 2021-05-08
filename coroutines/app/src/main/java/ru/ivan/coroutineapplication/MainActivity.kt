package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var scope:CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope = CoroutineScope(Job())

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

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d(TAG, "click")
        }

        val job = scope.launch {
            Log.d(TAG, "scope = $this")
        }
        Log.d(TAG, "job = $job")
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    companion object {
        private const val TAG = "Ivan"
    }
}