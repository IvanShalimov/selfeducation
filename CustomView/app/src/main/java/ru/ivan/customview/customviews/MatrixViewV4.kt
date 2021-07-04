package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixViewV4 @JvmOverloads constructor(
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
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255);

        canvas.drawCircle(400f, 200f, 10f, paint)

        path.reset()
        path.addRect(300f, 100f, 500f, 300f, Path.Direction.CW)
        canvas.drawPath(path, paint)

        //Перемещение после поворота
        myMatrix.reset()
        myMatrix.setRotate(45f, 400f, 200f)
        myMatrix.postTranslate(500f, 0f)
        path.transform(myMatrix, pathDst)
        paint.color = Color.GREEN
        canvas.drawPath(pathDst, paint)

        //Перемещение до поворота
        myMatrix.reset()
        myMatrix.setRotate(45f, 400f, 200f)
        myMatrix.preTranslate(500f, 0f)
        path.transform(myMatrix, pathDst)
        paint.color = Color.RED
        canvas.drawPath(pathDst, paint)
    }
}