package com.example.desafiofluxkotlin.people.adapters

import com.example.desafiofluxkotlin.people.model.People

interface PeopleItemListener {

    fun onItemClick(people: People.ResultsBean)
}