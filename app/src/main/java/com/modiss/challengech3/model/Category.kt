package com.modiss.challengech3.model

import java.util.UUID

data class Category(
    val id: String = UUID.randomUUID().toString(),
    val categoryImgUrl: String,
    val name: String
)