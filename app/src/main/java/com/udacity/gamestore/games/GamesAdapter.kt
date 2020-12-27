package com.udacity.gamestore.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.CardGameBinding


class GamesAdapter(
    private val games: MutableList<Game>
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {


    override fun getItemCount(): Int {
        return games.size
    }

    inner class GamesViewHolder(val cardGameBinding: CardGameBinding) :
        RecyclerView.ViewHolder(cardGameBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GamesViewHolder(
            DataBindingUtil.inflate<CardGameBinding>(
                LayoutInflater.from(parent.context),
                R.layout.card_game,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.cardGameBinding.game = games[position]
    }

}

