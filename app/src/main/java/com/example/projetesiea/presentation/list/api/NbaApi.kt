package com.example.projetesiea.presentation.list.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NbaApi {
    @GET("players")
    fun getShoesList(): Call<NbaResponse>

    @GET("players/{id}")
    fun getPlayersDetail(@Path ("id") id: Int): Call<NbaPlayers>
}