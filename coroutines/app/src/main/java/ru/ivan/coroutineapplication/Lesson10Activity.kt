package ru.ivan.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Lesson10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson10)
    }

    fun showExample(view: View) {
        val scope = CoroutineScope(Dispatchers.Main)
        log("scope, ${contextToString(scope.coroutineContext)}")

        scope.launch {
            log("scope, ${contextToString(this.coroutineContext)}")
        }
    }

    fun showContextForInnerCoroutines(view: View) {
        val userData:UserData = UserData(0, "Ivan", 10)
        val scope = CoroutineScope(Job() + Dispatchers.Main + userData)
        log("scope, ${contextToString(scope.coroutineContext)}")

        scope.launch {
            log("coroutine level1, ${contextToString(coroutineContext)}, userData ${coroutineContext[UserData]}")
            launch(Dispatchers.Default) {
                log("coroutine level2, ${contextToString(coroutineContext)}, userData ${coroutineContext[UserData]}")
                launch {
                    log("coroutine level3, ${contextToString(coroutineContext)}, userData ${coroutineContext[UserData]}")
                }
            }
        }
    }
}