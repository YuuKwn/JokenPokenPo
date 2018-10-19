package com.yuukwn.dontcare.api

import com.yuukwn.dontcare.model.Pontuacao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import  retrofit2.http.POST
import retrofit2.http.Path

interface JokenpokemonAPI {
    @POST("/jokenpokemon/pontuacao")
    fun salvarPontos(@Body pontuacao: Pontuacao) : Call<Void>


}