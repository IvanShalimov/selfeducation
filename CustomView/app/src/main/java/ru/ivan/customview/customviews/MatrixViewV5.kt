package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixViewV5 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val pathDst = Path()
    private val myMatrix = Matrix()

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        path.addRect(100f, 100f, 200f, 200f, Path.Direction.CW);
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255);

        canvas.drawPath(path, paint)

        // перемещение на 200 вправо
        // и наклон по вертикали на 0.5
        // точка наклона - слева
        myMatrix.reset()
        myMatrix.setTranslate(200f, 0f)
        myMatrix.postSkew(0.0f, 0.5f, 300f, 100f)
        path.transform(myMatrix, pathDst)
        canvas.drawPath(pathDst, paint)
        canvas.drawCircle(300f, 100f, 5f, paint)

        //Перемещаем на 400 и поворачивае на 0.5 по вертикали
        paint.color = Color.GREEN
        myMatrix.reset()
        myMatrix.setTranslate(400f, 0f)
        myMatrix.postSkew(0f, 0.5f, 300f, 100f)
        path.transform(myMatrix, pathDst)
        canvas.drawPath(pathDst, paint)
        canvas.drawCircle(300f, 100f, 5f, paint)

        paint.color = Color.BLUE
        //Перемещение на 150 вниз и поворот на 0.5 по горизонатил
        myMatrix.reset()
        myMatrix.setTranslate(0f, 150f)
        myMatrix.postSkew(0.5f, 0f, 100f, 250f)
        path.transform(myMatrix, pathDst)
        canvas.drawPath(pathDst, paint)
        canvas.drawCircle(100f, 250f, 5f, paint)

        //Перемещение на 300 вниз и наклон по горизонтали на 0.5
        myMatrix.reset()
        myMatrix.setTranslate(0f, 300f)
        myMatrix.postSkew(0.5f, 0f, 100f, 500f)
        path.transform(myMatrix, pathDst)
        canvas.drawPath(pathDst, paint)
        canvas.drawCircle(100f, 500f, 5f, paint)
    }
}