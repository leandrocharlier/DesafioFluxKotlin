package com.example.desafiofluxkotlin.people.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessScrollListener : RecyclerView.OnScrollListener() {

    private var loading: Boolean = false
    private val visibleThreshold = 20

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val linearLayoutManager = recyclerView
            .layoutManager as LinearLayoutManager?
        val visibleItemCount = linearLayoutManager?.childCount
        val totalItemCount: Int? = linearLayoutManager?.itemCount
        val pastVisiblesItems: Int? = linearLayoutManager?.findFirstVisibleItemPosition()
        if (loading) {
            if ((pastVisiblesItems?.let { visibleItemCount?.plus(it) })!! >= totalItemCount!!) {
                loading = false
                onLoadMore()
            }
        }
        if (!loading && (visibleItemCount?.let { totalItemCount?.minus(it) })!! <= (pastVisiblesItems?.plus(visibleThreshold))!!) {
            loading = true
        }
    }

    abstract fun onLoadMore()

}