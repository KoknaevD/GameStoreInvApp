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
            Game("Diablo",
                10.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.diablo_image)),

            Game("World of Warcraft: Frozen throne",
                15.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.wow_image)),

            Game("Dota",
                20.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.dota_image)),

            Game("CS:GO",
                25.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.cs_image)),

            Game("HALF:LIFE",
                30.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.hl_image)),

            Game("Starcraft",
                35.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.starcraft_image)),

            Game("New Game Test",
                45900.50,
                "test",
                "VERY NICE GAME",
                mutableListOf(R.drawable.image_available_soon))


        )
    }


}