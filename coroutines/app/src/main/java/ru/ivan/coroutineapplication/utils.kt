package ru.ivan.coroutineapplication

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private var formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

fun log(text: String) {
    Log.d(TAG, "${formatter.format(Date())} $text [${Thread.currentThread().name}]")
}

const val TAG = "Ivan"