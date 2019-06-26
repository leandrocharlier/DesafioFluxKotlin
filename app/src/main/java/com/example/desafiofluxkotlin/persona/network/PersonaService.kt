package com.example.desafiofluxkotlin.persona.network

import com.example.desafiofluxkotlin.persona.model.Persona
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonaService {

    @GET(".")
    fun obtenerPersonas(@Query("results") cantidad: Int): Single<Response<Persona>>

}