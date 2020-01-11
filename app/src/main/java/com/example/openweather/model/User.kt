package com.example.openweather.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String? = null,
    val location: String? = null
) : Parcelable