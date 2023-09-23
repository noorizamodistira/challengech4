package com.modiss.challengech3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Makanan(
    val nama: String,
    val harga: String,
    val photo: Int
) : Parcelable
