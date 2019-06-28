package com.example.desafiofluxkotlin.people.adapters

import android.widget.ImageView
import com.example.desafiofluxkotlin.people.model.People

interface PeopleItemListener {

    fun onItemClick(person: People.ResultsBean, personLogo: ImageView)
}