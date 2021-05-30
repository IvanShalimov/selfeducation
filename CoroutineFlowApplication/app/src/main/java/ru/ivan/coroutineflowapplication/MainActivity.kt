package ru.ivan.coroutineflowapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.ivan.coroutineflowapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MainViewModel::class.java
            )

        binding.actionButton.setOnClickListener {
            /*viewModel.count { number ->
                Log.d("Ivan", "current number is $number")
            }*/
            viewModel.`L-O-V_E_joke`()
        }

        binding.insultButton.setOnClickListener {
            viewModel.makeMeInsulted {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}