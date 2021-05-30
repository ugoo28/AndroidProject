package com.example.projetesiea.presentation.list

import com.example.projetesiea.presentation.list.api.NbaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object{
        val nbaApi : NbaApi = Retrofit.Builder()
                .baseUrl("https://www.balldontlie.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NbaApi::class.java)
    }
}

