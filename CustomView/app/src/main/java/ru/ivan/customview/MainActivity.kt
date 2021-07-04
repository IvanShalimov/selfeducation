package ru.ivan.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ivan.customview.customviews.MatrixView
import ru.ivan.customview.customviews.MatrixViewV2
import ru.ivan.customview.customviews.MatrixViewV3
import ru.ivan.customview.customviews.MatrixViewV4
import ru.ivan.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(MatrixViewV4(this))//binding.root
    }
}