package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixViewV6 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val myMatrix = Matrix()
    private val rectf = RectF(100f,100f,200f,200f)
    private val rectDst = RectF()

    init {
        paint.strokeWidth = 3f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawARGB(80, 102, 204, 255);

        path.reset()
        path.addRect(rectf, Path.Direction.CW)
        canvas.drawPath(path, paint)

        myMatrix.reset()
        myMatrix.setRotate(45f,150f,150f)
        myMatrix.postScale(1.2f,0.8f,150f,150f)
        myMatrix.postTranslate(200f, 0f)
        path.transform(myMatrix)

        paint.color = Color.GREEN
        canvas.drawPath(path, paint)

        myMatrix.mapRect(rectDst, rectf)
        paint.color = Color.BLUE
        canvas.drawRect(rectDst, paint)
    }
}