package com.example.desafiofluxkotlin.person_detail.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.person_detail.ResourceProvider
import com.example.desafiofluxkotlin.people.model.People
import javax.inject.Inject

class PersonDetailViewModel @Inject constructor(person: People.ResultsBean, resourceProvider: ResourceProvider) :
    ViewModel() {

    val SPACE: String = " "

    var person: People.ResultsBean? = null

    val personUser: MutableLiveData<String> = MutableLiveData()
    val personName: MutableLiveData<String> = MutableLiveData()
    val personAge: MutableLiveData<String> = MutableLiveData()
    val personEmail: MutableLiveData<String> = MutableLiveData()

    init {
        this.person = person
        personUser.value = person.login?.username
        personName.value = person.name?.first.plus(SPACE).plus(person.name?.last)
        personAge.value = resourceProvider.getString(R.string.age).plus(SPACE).plus(person.dob?.age.toString())
        personEmail.value = person.email
    }
}