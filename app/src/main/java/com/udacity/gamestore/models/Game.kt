package com.udacity.gamestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable