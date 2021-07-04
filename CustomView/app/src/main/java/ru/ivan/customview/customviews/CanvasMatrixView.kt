package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CanvasMatrixView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val myMatrix = Matrix()
    private val rectf = RectF(100f, 100f, 200f, 200f)

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255)

        path.reset()
        path.addRect(rectf, Path.Direction.CW)
        canvas.drawPath(path, paint)

        canvas.rotate(30f)
        canvas.translate(500f,0f)
        paint.color = Color.GREEN
        canvas.drawPath(path, paint)
    }
}