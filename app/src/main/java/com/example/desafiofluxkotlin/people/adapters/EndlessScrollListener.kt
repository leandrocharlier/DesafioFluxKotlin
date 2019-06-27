package com.example.desafiofluxkotlin.people.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessScrollListener(private val size: Int) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val linearLayoutManager = recyclerView
            .layoutManager as LinearLayoutManager?

        if (linearLayoutManager?.findLastCompletelyVisibleItemPosition() == size.minus (1)) {
            onLoadMore()

        }
    }

    abstract fun onLoadMore()

}