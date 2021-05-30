package com.example.projetesiea.presentation.list.api

import retrofit2.Call
import retrofit2.http.GET




interface NbaApi {
    @GET("players")
    fun getShoesList(): Call<NbaResponse>
}