package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultfavorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ivan.practicecoroutineapplication.R
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel

class FavoritesAdapter: RecyclerView.Adapter<FavoritesViewHolder>() {

    var list = mutableListOf<InsultPresentationModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorites_list_item, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class FavoritesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    fun bind (item: InsultPresentationModel) {
        itemView.findViewById<TextView>(R.id.favoriteItemTitle).text = item.insult
    }
}