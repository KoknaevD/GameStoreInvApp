package com.udacity.gamestore.games

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.gamestore.R

class GamesViewModel : ViewModel() {

    private val _games = MutableLiveData<MutableList<Game>>()
    val games: LiveData<MutableList<Game>>
        get() = _games


    lateinit var newGame: Game //i dont know how to do it without an open field with two way binding

    private fun resetNewGame() {
        newGame = Game("", 0.00, "", "", mutableListOf(R.drawable.image_available_soon))
    }

    init {
        Log.i("test", "GamesViewModel created")
        resetNewGame()
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

    fun addNewGame() {
        _games.value?.add(newGame)
        resetNewGame()
    }


    fun clearDetail() {
        resetNewGame()
    }


    fun isNewGameValid(): Boolean {
        return !(newGame.name.isEmpty() || newGame.company.isEmpty() || newGame.description.isEmpty() || newGame.price == 0.00)
    }
}