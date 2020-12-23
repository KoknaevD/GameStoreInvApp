package com.udacity.gamestore.games

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    var name: String, var price: Double, var company: String, var description: String,
    val images: List<Int> = mutableListOf()
) : Parcelable