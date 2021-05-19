package ru.ivan.practicecoroutineapplication.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        Log.d("Ivan","activity on Create")

        val myViewModel: MyViewModel = ViewModelProvider(this, MyCustomViewModelFabric(application, 0))
            .get(MyViewModel::class.java)

        myViewModel.getData().observe(this) {
            findViewById<TextView>(R.id.textView).text = it
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ivan","activity on Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ivan","activity on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ivan","activity on Destroy")
    }
}