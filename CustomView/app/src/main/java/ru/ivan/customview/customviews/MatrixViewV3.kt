package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import ru.ivan.customview.R

class MatrixViewV3 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val myMatrix = Matrix()

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
        paint.color = Color.GREEN
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255)

        //создаем крест
        path.reset()
        path.addRect(300f, 150f, 450f, 200f, Path.Direction.CW)
        path.addRect(350f, 100f, 400f, 250f, Path.Direction.CW)
        path.addCircle(374f, 125f, 5f, Path.Direction.CW)

        canvas.drawPath(path, paint)

        //Поворачиваем матрицу на 120 градусов относительно точки(по умолчанию 0, 0)
        myMatrix.reset()
        myMatrix.setRotate(120f, 600f,400f)

        path.transform(myMatrix)

        paint.color = Color.BLUE
        canvas.drawPath(path, paint)

        //Рисуем точку относительно которой поворот
        paint.color = Color.BLACK
        canvas.drawCircle(600f, 400f,5f,paint)
    }
}