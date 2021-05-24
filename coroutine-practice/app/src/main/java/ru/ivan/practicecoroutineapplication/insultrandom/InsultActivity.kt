package ru.ivan.practicecoroutineapplication.insultrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultfavorites.FavoriteInsultsFragment
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain.InsultMainFragment
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain.InsultMainViewModel

class InsultActivity : AppCompatActivity() {

    private var viewModel: InsultMainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insult_activity)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(InsultMainViewModel::class.java)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container, InsultMainFragment.newInstance())
            }
            viewModel?.let {
                it.changeFragment.observe(this) {
                    openFavoriteList()
                }
            }
        }
    }

    private fun openFavoriteList() {
        supportFragmentManager.commit {
            val fragment = FavoriteInsultsFragment.newInstance()
            addToBackStack("test")
            setReorderingAllowed(true)
            replace(R.id.container,fragment)
        }
    }
}