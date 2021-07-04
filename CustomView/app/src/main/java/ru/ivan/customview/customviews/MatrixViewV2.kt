package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixViewV2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val myMatrix = Matrix()

    init {
        paint.strokeWidth = 3f
        paint.style =  Paint.Style.STROKE
        paint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80,102,204,255)

        //создаем крест
        path.reset()
        path.addRect(300f,150f,450f,200f, Path.Direction.CW)
        path.addRect(350f,100f,400f,250f, Path.Direction.CW)

        //Рисуем зеленый крест
        canvas?.drawPath(path,paint)

        //Настраиваем матрицу на изменение размера
        //в 2 раза по горизонтали
        // в 2.5 раза по вертикали
        myMatrix.reset()
        myMatrix.setScale(2f,2.5f,375f,100f)

        path.transform(myMatrix)

        paint.color = Color.BLUE
        canvas?.drawPath(path, paint)

        //Рисуем точку от которой было масштабировани для наглядности
        paint.color = Color.BLACK
        canvas?.drawCircle(375f,100f,5f, paint)
    }
}