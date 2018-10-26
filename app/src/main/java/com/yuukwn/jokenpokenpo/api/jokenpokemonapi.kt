package com.yuukwn.jokenpokenpo.api

import com.yuukwn.jokenpokenpo.model.Pontuacao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import  retrofit2.http.POST

interface JokenpokemonAPI {
    @GET("/jokenpokemon/pontuacao")
    fun buscarPontuacao(): Call<List<Pontuacao>>

    @POST("/jokenpokemon/pontuacao")
    fun salvarPontos(@Body  pontuacao: Pontuacao) : Call<Void>


}