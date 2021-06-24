package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PathDrawableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr){


    private val paint = Paint()
    private val rectf = RectF(350f, 100f, 400f, 150f)
    private val path = Path()
    private val path1 = Path()

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80, 102, 204, 255)

        //Очистка path
        path.reset()

        //Угол
        path.moveTo(100f, 100f)
        path.lineTo(150f, 200f)
        path.lineTo(50f, 200f)

        //Треугольник
        path.moveTo(250f, 100f)
        path.lineTo(300f, 200f)
        path.lineTo(200f, 200f)

        path.close()

        //Квадрат и круг
        path.addRect(rectf, Path.Direction.CW)
        path.addCircle(450f, 150f, 25f, Path.Direction.CW)

        paint.color = Color.BLACK
        canvas?.drawPath(path, paint)

        path1.reset()
        path1.moveTo(50f,50f)
        path1.lineTo(500f, 250f)
        path1.moveTo(500f, 50f)
        path1.lineTo(50f, 250f)

        paint.color = Color.GREEN
        canvas?.drawPath(path1, paint)

        path.addPath(path1)

        path.offset(500f,100f)

        paint.color = Color.BLUE
        canvas?.drawPath(path, paint)
    }
}