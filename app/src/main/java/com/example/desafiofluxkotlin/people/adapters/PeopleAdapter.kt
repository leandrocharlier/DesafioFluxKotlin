package com.example.desafiofluxkotlin.people.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.people.model.People
import kotlinx.android.synthetic.main.persona_item.view.*

class PeopleAdapter(var items: List<People.ResultsBean>, val listener: PeopleItemListener) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.persona_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    fun updatePeople(items: List<People.ResultsBean>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val SPACE = " "

        fun bind(item: People.ResultsBean, listener: PeopleItemListener) = with(itemView) {
            Glide.with(context)
                .load(item.picture?.thumbnail)
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(0.1f)
                .into(peopleLogo)
            peopleUser.text = item.login?.username
            peopleName.text = item.name?.first.plus(SPACE).plus(item.name?.last)
            setOnClickListener { listener.onItemClick(item) }
        }
    }
}