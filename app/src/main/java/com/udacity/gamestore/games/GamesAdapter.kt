package com.udacity.gamestore.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.RecyclerviewGame2Binding


class GamesAdapter(
    private val games: Array<Game>
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {


    override fun getItemCount(): Int {
        return games.size
    }

    inner class GamesViewHolder(val recyclerviewGame2Binding: RecyclerviewGame2Binding) : RecyclerView.ViewHolder(recyclerviewGame2Binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GamesViewHolder(
            DataBindingUtil.inflate<RecyclerviewGame2Binding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_game2,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.recyclerviewGame2Binding.game = games[position]
    }

}

