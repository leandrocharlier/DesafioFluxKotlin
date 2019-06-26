package com.example.desafiofluxkotlin.persona.network

import android.annotation.SuppressLint
import com.example.desafiofluxkotlin.DaggerPersonaInjector
import com.example.desafiofluxkotlin.persona.model.Persona
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonaRepository @Inject constructor() {

    @Inject
    lateinit var personaService: PersonaService

    init {
        DaggerPersonaInjector.create().apply { inject(this@PersonaRepository) }
    }

    @SuppressLint("CheckResult")
    fun obtenerPersonas(
        succesConsumer: Consumer<Response<Persona>>,
        errorConsumer: Consumer<Throwable>,
        cantidad: Int
    ) {
        personaService.obtenerPersonas(cantidad)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(succesConsumer, errorConsumer)
    }
}