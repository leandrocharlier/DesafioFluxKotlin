package com.example.desafiofluxkotlin

import com.example.desafiofluxkotlin.people.network.PeopleRepository
import com.example.desafiofluxkotlin.people.view.MainActivity
import com.example.desafiofluxkotlin.people.viewmodel.PeopleViewModel
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface PeopleInjector {

    fun inject(peopleRepository: PeopleRepository)
    fun inject(peopleViewModel: PeopleViewModel)
    fun inject(mainActivity: MainActivity)

}