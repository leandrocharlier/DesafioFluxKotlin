package com.example.desafiofluxkotlin.person_detail.di

import com.example.desafiofluxkotlin.people.model.People
import dagger.Module
import dagger.Provides

@Module
class PersonModule(person: People.ResultsBean) {

    var person: People.ResultsBean? = null

    init {
        this.person = person
    }

    @Provides
    fun providePerson(): People.ResultsBean {
        return person!!
    }

}