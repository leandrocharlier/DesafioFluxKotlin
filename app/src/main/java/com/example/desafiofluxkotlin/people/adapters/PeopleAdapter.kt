package com.example.desafiofluxkotlin.people.adapters

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.people.model.People
import kotlinx.android.synthetic.main.persona_item.view.*
import java.util.*

class PeopleAdapter(private val listener: PeopleItemListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    private var items: List<People.ResultsBean> = Collections.emptyList()
    private var showLoading: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.persona_item, parent, false))
        } else {
            LoadingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.loading_item, parent, false))
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is ItemViewHolder) {
            viewHolder.bind(items[position], listener)
        }
    }

    override fun getItemCount(): Int {
        return if (items.isNotEmpty() && showLoading) items.size + 1
        else return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position >= items.size && showLoading) {
            return VIEW_TYPE_LOADING
        }
        return VIEW_TYPE_ITEM
    }

    fun updatePeople(items: List<People.ResultsBean>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setLoading(showLoading: Boolean) {
        this.showLoading = showLoading
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val SPACE = " "

        fun bind(item: People.ResultsBean, listener: PeopleItemListener) = with(itemView) {
            Glide.with(context)
                .load(item.picture?.thumbnail)
                .apply(RequestOptions.circleCropTransform())
                .into(personLogo)
            ViewCompat.setTransitionName(personLogo, item.id?.name)
            personUser.text = item.login?.username
            personName.text = item.name?.first.plus(SPACE).plus(item.name?.last)
            setOnClickListener { listener.onItemClick(item, personLogo) }
        }
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}