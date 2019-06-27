package com.example.desafiofluxkotlin.people.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.desafiofluxkotlin.DaggerPeopleInjector
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.people.network.PeopleRepository
import io.reactivex.functions.Consumer
import javax.inject.Inject

class PeopleViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var peopleRepository: PeopleRepository

    val ERROR: String = "ERROR"
    val EXITO: String = "ÉXITO"

    var message: MutableLiveData<String> = MutableLiveData()
    var peopleList: MutableLiveData<People> = MutableLiveData()

    init {
        DaggerPeopleInjector.create().apply { inject(this@PeopleViewModel) }
    }

    fun getPeople(quantity: Int) {
        peopleRepository.getPeople(Consumer {
            if (it.isSuccessful) {
                peopleList.value = it.body()
                message.value = EXITO
            } else {
                message.value = ERROR
            }
        }, Consumer {
            message.value = ERROR
        }, quantity)
    }


}