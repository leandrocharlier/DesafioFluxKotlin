package com.example.desafiofluxkotlin.person_detail.di

import com.example.desafiofluxkotlin.person_detail.view.PersonDetailActivity
import dagger.Component

@Component(modules = [(PersonModule::class), (ResourceModule::class)])
interface PersonComponent {
    fun inject(personDetailActivity: PersonDetailActivity)
}