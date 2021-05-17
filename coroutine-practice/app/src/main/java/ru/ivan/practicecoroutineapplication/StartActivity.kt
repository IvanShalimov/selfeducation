package ru.ivan.practicecoroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class StartActivity : AppCompatActivity() {

    private var server: MyServer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        server = MyServer()

        val data = server?.subscribeDigital()
        data?.observe(this) {
            findViewById<TextView>(R.id.authLabel).text = "$it"
        }

        findViewById<Button>(R.id.auth).setOnClickListener {
            server?.auth()

        }
    }

    override fun onResume() {
        super.onResume()

        server?.let {
            lifecycle.addObserver(it,)
        }
    }

    override fun onDestroy() {
        server?.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()

    }
}