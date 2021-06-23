package ru.ivan.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ivan.customview.customviews.DrawSurfaceView
import ru.ivan.customview.customviews.PathCurveDrawable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawSurfaceView(this))
    }
}