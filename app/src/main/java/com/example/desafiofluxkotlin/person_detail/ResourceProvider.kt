package com.example.desafiofluxkotlin.person_detail

import android.content.Context
import javax.inject.Inject

class ResourceProvider @Inject constructor(private var context: Context) {

    fun getString(resId: Int): String {
        return context.getString(resId)
    }

}