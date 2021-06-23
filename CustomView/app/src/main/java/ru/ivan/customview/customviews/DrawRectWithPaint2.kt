package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class DrawRectWithPaint2 : View {

    private val paint = Paint()
    private val rectf = RectF(700f, 100f, 800f, 150f)
    private val points =
        arrayOf(100f, 50f, 150f, 100f, 150f, 200f, 50f, 200f, 50f, 100f).toFloatArray()
    private val points1 = arrayOf(
        300f,
        200f,
        600f,
        200f,
        300f,
        300f,
        600f,
        300f,
        400f,
        100f,
        400f,
        400f,
        500f,
        100f,
        500f,
        400f
    ).toFloatArray()


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80, 102, 204, 255)

        paint.color = Color.RED
        paint.strokeWidth = 10f
        //Рисуем много точек
        canvas?.drawPoints(points, paint)

        //Рисуем много линий
        canvas?.drawLines(points1, paint)

        //Меняем цвет кисти
        paint.color = Color.GREEN

        //Рисуем прямоугольник с закругленными углами
        canvas?.drawRoundRect(rectf, 20f, 20f, paint)

        //Смещаем координаты прямоуголника вниз
        rectf.offset(0f, 150f)

        //Рисуем овал внутри прямоугольника
        canvas?.drawOval(rectf, paint)

        //Смещаем на указанные координаты
        rectf.offsetTo(900f, 100f)

        rectf.inset(0f, -25f)

        //Рисуем дугу
        canvas?.drawArc(rectf, 90f, 270f, true, paint)

        rectf.offset(0f, 150f)

        canvas?.drawArc(rectf, 90f, 270f, false, paint)

        paint.strokeWidth = 3f

        canvas?.drawLine(150f, 450f, 150f, 600f, paint)

        paint.color = Color.BLUE

        //Размер текста
        paint.textSize = 30f

        //Рисуем текст
        canvas?.drawText("text left", 150f, 500f, paint)

        //Выравниваем текст
        paint.textAlign = Paint.Align.CENTER

        canvas?.drawText("text center", 150f, 525f, paint)

        paint.textAlign = Paint.Align.RIGHT

        canvas?.drawText("text right", 150f, 550f, paint)
    }
}