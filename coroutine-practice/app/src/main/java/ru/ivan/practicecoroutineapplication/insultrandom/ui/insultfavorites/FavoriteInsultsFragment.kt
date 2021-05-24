package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultfavorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ivan.practicecoroutineapplication.R
import ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain.InsultMainViewModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel


class FavoriteInsultsFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteInsultsFragment()
    }

    private lateinit var viewModel: InsultMainViewModel
    private val adapter:FavoritesAdapter = FavoritesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_insults, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(InsultMainViewModel::class.java)

        val recycler = view.findViewById<RecyclerView>(R.id.favoritesList)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        viewModel.getFavoritesList().observe(this as LifecycleOwner) { list ->
            adapter.list = list as MutableList<InsultPresentationModel>
        }
    }

}