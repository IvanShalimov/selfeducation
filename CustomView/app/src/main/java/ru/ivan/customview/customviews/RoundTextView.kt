package ru.ivan.customview.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class RoundTextView: View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var text = "Draw the text, with origin at (x,y), using the specified paint\""

    init {
        paint.textSize = 20f
        paint.strokeWidth = 1f
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
        canvas?.drawARGB(80, 102, 204, 255);

        //Черный
        path.reset()
        path.addCircle(200f,200f,100f,Path.Direction.CW)
        paint.color = Color.BLACK
        canvas?.drawTextOnPath(text,path,0f,0f,paint)

        path.reset()
        path.addCircle(500f,200f,100f,Path.Direction.CCW)

        //Синий
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas?.drawTextOnPath(text,path,0f,0f,paint)
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path,paint)

        // зеленый
        path.offset(-300f, 250f)
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        canvas?.drawTextOnPath(text, path, 100f, 0f, paint)
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)

        // красный
        path.offset(300f, 0f)
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        canvas?.drawTextOnPath(text, path, 0f, 30f, paint)
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)
    }
}