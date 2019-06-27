package com.example.desafiofluxkotlin.people.network

import android.annotation.SuppressLint
import com.example.desafiofluxkotlin.DaggerPeopleInjector
import com.example.desafiofluxkotlin.people.model.People
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class PeopleRepository @Inject constructor() {

    @Inject
    lateinit var peopleService: PeopleService

    init {
        DaggerPeopleInjector.create().apply { inject(this@PeopleRepository) }
    }

    @SuppressLint("CheckResult")
    fun getPeople(
        succesConsumer: Consumer<Response<People>>,
        errorConsumer: Consumer<Throwable>,
        quantity: Int
    ) {
        peopleService.getPeople(quantity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(succesConsumer, errorConsumer)
    }

    @SuppressLint("CheckResult")
    fun getPeopleWithSeed(
        succesConsumer: Consumer<Response<People>>,
        errorConsumer: Consumer<Throwable>,
        quantity: Int,
        seed: String,
        page: Int
    ) {
        peopleService.getPeopleWithSeed(quantity, seed, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(succesConsumer, errorConsumer)
    }
}