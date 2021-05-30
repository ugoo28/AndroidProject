package com.example.projetesiea.presentation.list.api

data class NbaResponse (
    val data : List <NbaPlayers>
)

data class NbaPlayers (
        val team : Team,
        val id : Int,
        val first_name : String,
        val last_name : String
)

data class Team (
    val id : Int,
    val abbrevation : String,
    val city : String,
    val conference : String,
    val full_name : String
)