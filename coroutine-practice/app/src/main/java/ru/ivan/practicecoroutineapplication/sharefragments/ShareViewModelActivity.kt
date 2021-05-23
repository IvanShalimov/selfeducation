package ru.ivan.practicecoroutineapplication.sharefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R

class ShareViewModelActivity : AppCompatActivity() {

    private var viewModel:SharedViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_view_model)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(SharedViewModel::class.java)
        viewModel?.let { model ->
            model.subscribeFlag().observe(this){ flag ->
                when (flag) {
                    0 -> {
                        attachMasterFragment()
                    }
                    1 -> {
                        attachDetailFragment()
                    }
                }

            }
        }

        attachMasterFragment()
    }

    private fun attachMasterFragment() {
        val masterFragment = MainFragment.newInstance()
        supportFragmentManager.commit{
            replace(R.id.container, masterFragment)
        }
    }

    private fun attachDetailFragment() {
        val detail = DetailFragment.newInstance()
        supportFragmentManager.commit{
            addToBackStack("test")
            setReorderingAllowed(true)
            replace(R.id.container, detail)
        }
    }
}