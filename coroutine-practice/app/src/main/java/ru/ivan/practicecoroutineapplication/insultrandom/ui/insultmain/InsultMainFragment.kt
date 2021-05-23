package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import ru.ivan.practicecoroutineapplication.R

class InsultMainFragment : Fragment() {

    companion object {
        fun newInstance() = InsultMainFragment()
    }

    private lateinit var viewModel: InsultMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.insult_main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it,
                ViewModelProvider.AndroidViewModelFactory(it.application))
                .get(InsultMainViewModel::class.java)
            viewModel.insult.observe(this as LifecycleOwner) { model ->
                view.findViewById<TextView>(R.id.message).text = model.insult
            }
            view.findViewById<Button>(R.id.moreInsultButton).setOnClickListener {
                viewModel.fetchInsult()
            }
        }


    }

}