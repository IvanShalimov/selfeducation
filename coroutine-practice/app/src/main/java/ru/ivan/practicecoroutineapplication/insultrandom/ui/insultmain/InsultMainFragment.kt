package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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
            viewModel.changeIcon.observe(this as LifecycleOwner) { flag ->
                view.findViewById<ImageView>(R.id.favoriteIcon).setImageDrawable(it.getDrawable(R.drawable.ic_baseline_favorite_24))
            }


            view.findViewById<Button>(R.id.moreInsultButton).setOnClickListener {
                viewModel.fetchInsult()
            }
            view.findViewById<ImageView>(R.id.favoriteIcon).setOnClickListener {
                viewModel.onFavoriteClick()
            }
            view.findViewById<ImageView>(R.id.favoriteListIButton).setOnClickListener {
                viewModel.changeFragment.value = true
            }
        }


    }

}