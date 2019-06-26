package com.example.desafiofluxkotlin.persona.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.desafiofluxkotlin.DaggerPersonaInjector
import com.example.desafiofluxkotlin.persona.model.Persona
import com.example.desafiofluxkotlin.persona.network.PersonaRepository
import io.reactivex.functions.Consumer
import javax.inject.Inject

class PersonaViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var personaRepository: PersonaRepository

    var mensajeError: MutableLiveData<String> = MutableLiveData()
    var listaPersonas: MutableLiveData<Persona> = MutableLiveData()
    var nombre: MutableLiveData<String> = MutableLiveData()

    init {
        DaggerPersonaInjector.create().apply { inject(this@PersonaViewModel) }
    }

    fun getPersonas(cantidad: Int) {
        personaRepository.obtenerPersonas(Consumer {
            if (it.isSuccessful) {
                listaPersonas.value = it.body()
                nombre.value = it.body()?.results?.get(0)?.name?.first
            } else {
                mensajeError.value = "Error desde response"
            }
        }, Consumer {
            mensajeError.value = "Error desde failure"
        }, cantidad)
    }


}