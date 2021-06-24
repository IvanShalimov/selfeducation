package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PathCurveDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    private val point1 = Point(200, 300)
    private val point21 = Point(500, 600)
    private val point22 = Point(900, 200)

    init {
        paint.strokeWidth = 3f
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80, 102,204,255)

        //Первая линия
        paint.color = Color.BLACK
        canvas?.drawLine(100f, 100f, 600f, 100f, paint)

        //Точка отклонения для первой линии
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        canvas?.drawCircle(point1.x.toFloat(), point1.y.toFloat(), 10f, paint)

        //Квадратичная прямая
        path.reset()
        path.moveTo(100f, 100f)
        path.quadTo(point1.x.toFloat(), point1.y.toFloat(), 600f, 100f)
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)

        //Вторая линия
        paint.color = Color.BLACK
        canvas?.drawLine(400f, 400f, 1100f, 400f, paint)

        //Точка отклонения для второй линии
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        canvas?.drawCircle(point21.x.toFloat(), point21.y.toFloat(), 10f, paint)
        canvas?.drawCircle(point22.x.toFloat(), point22.y.toFloat(), 10f, paint)

        // Кубическая кривая
        path.reset()
        path.moveTo(400f, 400f)
        path.cubicTo(point21.x.toFloat(), point21.y.toFloat(), point22.x.toFloat(), point22.y.toFloat(), 1100f, 400f)
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)
    }
}