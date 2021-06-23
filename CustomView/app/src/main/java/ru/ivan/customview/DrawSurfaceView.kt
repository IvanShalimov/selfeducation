package ru.ivan.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView

class DrawSurfaceView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    lateinit var drawThread:DrawThread

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        Log.d("Ivan","surfaceCreated")
        drawThread = DrawThread(holder)
        drawThread.running = true
        drawThread.start()
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
        Log.d("Ivan","surfaceChanged")
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        Log.d("Ivan","surfaceDestroyed")
        var retry = true
        drawThread.running = false
        while (retry) {
            try {
                drawThread.join()
                retry = false
            } catch (e:InterruptedException) {

            }
        }
    }

    class DrawThread(private var surfaceHolder:SurfaceHolder) : Thread() {
        var running = false

        override fun run() {
            var canvas:Canvas?
            while (running) {
                canvas = null
                try {
                    canvas = surfaceHolder.lockCanvas()
                    canvas?.let {
                        it.drawColor(Color.GREEN)
                    } ?: continue
                } finally {
                    canvas?.let {
                        surfaceHolder.unlockCanvasAndPost(canvas)
                    }
                }
            }
        }
    }
}