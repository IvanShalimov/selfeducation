package ru.ivan.practicecoroutineapplication.insultrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.ivan.practicecoroutineapplication.R
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain.InsultMainFragment

class InsultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insult_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container, InsultMainFragment.newInstance())
            }
        }
    }
}