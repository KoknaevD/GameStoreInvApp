package com.udacity.gamestore.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.RecyclerviewGameBinding


class GamesAdapter(
    private val games: Array<Game>
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {


    override fun getItemCount(): Int {
        return games.size
    }

    inner class GamesViewHolder(val recyclerviewGameBinding: RecyclerviewGameBinding) : RecyclerView.ViewHolder(recyclerviewGameBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GamesViewHolder(
            DataBindingUtil.inflate<RecyclerviewGameBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_game,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.recyclerviewGameBinding.game = games[position]
    }

}

