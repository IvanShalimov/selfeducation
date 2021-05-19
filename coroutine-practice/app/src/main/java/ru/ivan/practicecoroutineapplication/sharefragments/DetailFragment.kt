package ru.ivan.practicecoroutineapplication.sharefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var model: SharedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        activity?.let {
            model = ViewModelProvider(it,
                ViewModelProvider.AndroidViewModelFactory(it.application))
                .get(SharedViewModel::class.java)
        }
        model?.subscribeData()?.observe(this as LifecycleOwner) {
            view.findViewById<TextView>(R.id.result_text).text = it
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DetailFragment.
         */
        @JvmStatic
        fun newInstance() = DetailFragment()
    }
}