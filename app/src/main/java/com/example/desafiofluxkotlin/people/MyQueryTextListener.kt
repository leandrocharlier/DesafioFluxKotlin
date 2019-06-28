package com.example.desafiofluxkotlin.people

import android.widget.SearchView

abstract class MyQueryTextListener : SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let { onSearch(it) }
        return false
    }

    abstract fun onSearch(text : String)
}