package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CanvasRestoreView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val rectf1 = RectF(50f, 50f, 100f, 100f)
    private val rectf2 = RectF(50f, 150f, 100f, 200f)
    private val rectf3 = RectF(50f, 300f, 100f, 350f)

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
        paint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255)

        canvas.drawRect(rectf1, paint)
        canvas.save();

        canvas.translate(100f, 0f)
        canvas.drawRect(rectf1, paint)
        canvas.translate(100f, 0f)
        canvas.drawRect(rectf1, paint)
        val savePoint = canvas.save();
        canvas.translate(100f, 0f)
        canvas.drawRect(rectf1, paint)

        canvas.restore()
        paint.color = Color.BLUE
        canvas.drawRect(rectf2, paint)

        canvas.restore()
        paint.color = Color.BLACK
        canvas.drawRect(rectf2, paint)

        canvas.restoreToCount(savePoint)
        paint.color = Color.RED
        canvas.drawRect(rectf3, paint)
    }
}