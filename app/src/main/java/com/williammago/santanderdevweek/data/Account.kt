package com.williammago.santanderdevweek.data

data class Account(
    val account : String,
    val agency : String,
    val balance : Float,
    val limit : Float,
    val client : Client,
    val card: Card,
)
