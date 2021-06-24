package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.lang.StringBuilder

class DrawableWithStringBuilder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val rect = Rect(100,200,200,300)
    private val stringBuilder = StringBuilder()

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80,102, 204,255)

        paint.color = Color.BLUE
        paint.strokeWidth = 10f

        paint.textSize = 30f

        //Создаем строку со значением ширины и высаты холста
        stringBuilder.setLength(0)
        stringBuilder.append("width =")
            .append(canvas?.width?: "")
            .append(" height = ")
            .append(canvas?.height ?: "")

        canvas?.drawText(stringBuilder.toString(), 100f, 100f, paint)

        //Выставляем стиль заливка
        paint.style = Paint.Style.FILL
        canvas?.drawRect(rect,paint)

        //Перенастраиваем кисть на контур
        paint.style = Paint.Style.STROKE
        rect.offset(150,0)
        canvas?.drawRect(rect,paint)

        //Перенастраиваем кисть на заливку и контуры
        paint.style = Paint.Style.FILL_AND_STROKE
        rect.offset(150,0)
        canvas?.drawRect(rect,paint)
    }
}