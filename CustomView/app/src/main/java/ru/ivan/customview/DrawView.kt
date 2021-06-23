package ru.ivan.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

class DrawView(context: Context): View(context) {

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(Color.GREEN)
    }
}