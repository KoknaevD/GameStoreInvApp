package com.udacity.gamestore.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GamesViewModel : ViewModel() {

    private val _games = MutableLiveData<Array<Game>>()
    val games : LiveData<Array<Game>>
        get() = _games

    init {
        _games.value = arrayOf(
            Game("Diablo", 10.50, "Blizzard", "a game"),
            Game("Warcraft", 15.50, "Blizzard", "a game"),
            Game("Dota", 20.50, "Valve", "a game"),
            Game("CS:GO", 25.50, "Valve", "a game"),
            Game("HALF:LIFE", 30.50, "Valve", "a game"),
            Game("Starcraft", 35.50, "Blizzard", "a game")
        )
    }


}