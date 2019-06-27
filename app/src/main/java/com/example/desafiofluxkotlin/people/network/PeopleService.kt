package com.example.desafiofluxkotlin.people.network

import com.example.desafiofluxkotlin.people.model.People
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleService {

    @GET(".")
    fun getPeople(@Query("results") cantidad: Int): Single<Response<People>>

    @GET(".")
    fun getPeopleWithSeed(@Query("results") cantidad: Int,
                          @Query("seed") seed: String,
                          @Query("page") page: Int): Single<Response<People>>

}