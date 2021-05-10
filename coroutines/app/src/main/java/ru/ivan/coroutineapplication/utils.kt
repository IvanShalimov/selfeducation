package ru.ivan.coroutineapplication

import android.util.Log
import kotlinx.coroutines.Job
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

private var formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

fun log(text: String) {
    Log.d(TAG, "${formatter.format(Date())} $text [${Thread.currentThread().name}]")
}

fun contextToString(context: CoroutineContext) : String =
    "Job = ${context[Job]}, Dispatcher = ${context[ContinuationInterceptor]}"

const val TAG = "Ivan"