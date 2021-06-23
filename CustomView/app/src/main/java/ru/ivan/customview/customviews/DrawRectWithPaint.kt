package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawRectWithPaint : View {

    private val paint = Paint()
    private val rect = Rect()

    //Необходимые для View в layout конструкторы.
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //Заливаем холст цветом
        canvas?.drawARGB(80, 102, 204, 255)

        //Настроил цвет кисти
        paint.color = Color.RED
        //Натсроил толщину кисти
        paint.strokeWidth = 10f

        //Рисуем точку
        canvas?.drawPoint(50f, 50f, paint)

        //Рисуем линию
        canvas?.drawLine(100f, 100f, 500f, 50f, paint)

        //Рисуем круг
        canvas?.drawCircle(100f, 200f, 50f, paint)

        //Рисуем прямоугольник
        //вернхняя левая, нижняя правая
        canvas?.drawRect(200f, 150f, 400f, 200f, paint)

        //Альтернативный способ нарисовать прямоугольник
        //вернхняя левая, нижняя правая
        rect.set(250, 300, 350, 500)
        canvas?.drawRect(rect, paint)

    }
}