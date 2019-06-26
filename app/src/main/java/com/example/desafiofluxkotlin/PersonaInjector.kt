package com.example.desafiofluxkotlin

import com.example.desafiofluxkotlin.persona.network.PersonaRepository
import com.example.desafiofluxkotlin.persona.viewmodel.PersonaViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface PersonaInjector {

    fun inject(personaRepository: PersonaRepository)
    fun inject(personaViewModel: PersonaViewModel)
    fun inject(mainActivity: MainActivity)

}