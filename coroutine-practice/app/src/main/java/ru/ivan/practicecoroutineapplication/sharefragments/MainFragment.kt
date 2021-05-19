package ru.ivan.practicecoroutineapplication.sharefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private var viewModel:SharedViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        activity?.let {
            viewModel = ViewModelProvider(it,
                ViewModelProvider.AndroidViewModelFactory(it.application))
                .get(SharedViewModel::class.java)
        }


        view.findViewById<Button>(R.id.button).setOnClickListener {
            val value = view.findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            viewModel?.setValue(value)
            viewModel?.setFlag(1)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}