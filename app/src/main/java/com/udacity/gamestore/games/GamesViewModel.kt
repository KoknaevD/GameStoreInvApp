package com.udacity.gamestore.games

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.gamestore.R

class GamesViewModel : ViewModel() {

    private val _games = MutableLiveData<MutableList<Game>>()
    val games: LiveData<MutableList<Game>>
        get() = _games


    var newGame = getGame()

    private fun getGame(): Game = Game("", 0.00, "","", mutableListOf(R.drawable.image_available_soon))



    init {
        Log.i("test", "GamesViewModel created")
        _games.value = mutableListOf(
            Game(
                "Diablo",
                10.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.diablo_image)
            ),

            Game(
                "World of Warcraft: Frozen throne",
                15.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.wow_image)
            ),

            Game(
                "Dota",
                20.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.dota_image)
            ),

            Game(
                "CS:GO",
                25.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.cs_image)
            ),

            Game(
                "HALF:LIFE",
                30.50,
                "Valve",
                "a game",
                mutableListOf(R.drawable.hl_image)
            ),

            Game(
                "Starcraft",
                35.50,
                "Blizzard",
                "a game",
                mutableListOf(R.drawable.starcraft_image)
            ),

            Game(
                "New Game Test",
                45900.50,
                "test",
                "VERY NICE GAME",
                mutableListOf(R.drawable.image_available_soon)
            )


        )
    }

    fun addNewGame(name: String, price: Double, company: String, description: String) {
        _games.value?.add(newGame)
        clear()
    }


    fun clear() {
        newGame = getGame()
    }

}