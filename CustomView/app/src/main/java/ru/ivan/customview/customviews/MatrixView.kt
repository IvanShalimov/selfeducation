package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixView: View {

    private val paint = Paint()
    private val path = Path()
    private val myMatrix = Matrix()

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
    }

    //Необходимые для View в layout конструкторы.
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawARGB(80, 102,204, 255)

        //Создаем крест
        path.addRect(300f, 150f, 450f, 200f, Path.Direction.CW)
        path.addRect(350f, 100f, 400f, 250f, Path.Direction.CW)

        paint.color = Color.GREEN
        canvas?.drawPath(path, paint)

        //Настраиваем матрицу на смещение
        matrix.reset()
        matrix.setTranslate(300f, 200f)

        path.transform(matrix)

        paint.color = Color.BLUE
        canvas?.drawPath(path, paint)
    }
}