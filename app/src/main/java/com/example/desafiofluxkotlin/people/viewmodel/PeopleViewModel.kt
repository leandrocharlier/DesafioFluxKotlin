package com.example.desafiofluxkotlin.people.viewmodel

import android.arch.lifecycle.*
import com.example.desafiofluxkotlin.DaggerPeopleInjector
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.people.network.PeopleRepository
import io.reactivex.functions.Consumer
import java.util.ArrayList
import javax.inject.Inject

class PeopleViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var peopleRepository: PeopleRepository

    val ERROR: String = "ERROR"
    val EXITO: String = "ÉXITO"

    var message: MutableLiveData<String> = MutableLiveData()
    var peopleList: MutableLiveData<People> = MutableLiveData()
    var page: Int = 1

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

    fun getPeopleWithSeed(quantity: Int, seed: String) {
        page = page.plus(1)
        peopleRepository.getPeopleWithSeed(Consumer {
            if (it.isSuccessful) {
                (peopleList.value?.results as ArrayList).addAll(it.body()?.results as ArrayList)
                peopleList.value = peopleList.value
                message.value = EXITO
            } else {
                message.value = ERROR
            }
        }, Consumer {
            message.value = ERROR
        }, quantity, seed, page)
    }

    fun filterPeople(text: String): List<People.ResultsBean> {
        return peopleList.value?.results?.let {
            it.filter { resultsBean -> resultsBean.login?.username!!.contains(text) }
        }!!
    }


}