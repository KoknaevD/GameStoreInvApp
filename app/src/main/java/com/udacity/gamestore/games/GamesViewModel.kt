package com.udacity.gamestore.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.gamestore.R

class GamesViewModel : ViewModel() {

    private val _games = MutableLiveData<Array<Game>>()
    val games : LiveData<Array<Game>>
        get() = _games

    init {
        _games.value = arrayOf(
            Game("Diablo", 10.50, "Blizzard", "a game", mutableListOf(), R.drawable.icon),
            Game("World of Warcraft: Frozen throne", 15.50, "Blizzard", "a game", mutableListOf(R.drawable.hl_image)),
            Game("Dota", 20.50, "Valve", "a game", mutableListOf(R.drawable.hl_image)),
            Game("CS:GO", 25.50, "Valve", "a game", mutableListOf(R.drawable.hl_image)),
            Game("HALF:LIFE", 30.50, "Valve", "a game", mutableListOf(R.drawable.hl_image)),
            Game("Starcraft", 35.50, "Blizzard", "a game", mutableListOf(R.drawable.hl_image))
        )
    }


}