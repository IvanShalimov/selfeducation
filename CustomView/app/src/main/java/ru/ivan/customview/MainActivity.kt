package ru.ivan.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ivan.customview.customviews.DrawableWithStringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawableWithStringBuilder(this))
    }
}