package com.dicoding.footballstar

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Football(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
