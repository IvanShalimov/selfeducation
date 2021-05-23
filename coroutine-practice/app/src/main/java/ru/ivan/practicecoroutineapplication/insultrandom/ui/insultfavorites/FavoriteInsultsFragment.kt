package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultfavorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import ru.ivan.practicecoroutineapplication.R
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain.InsultMainViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteInsultsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteInsultsFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteInsultsFragment()
    }

    private lateinit var viewModel: InsultMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_insults, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(InsultMainViewModel::class.java)

    }

}