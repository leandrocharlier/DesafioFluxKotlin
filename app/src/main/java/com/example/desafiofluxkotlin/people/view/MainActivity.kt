package com.example.desafiofluxkotlin.people.view

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.example.desafiofluxkotlin.DaggerPeopleInjector
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.databinding.ActivityMainBinding
import com.example.desafiofluxkotlin.people.adapters.PeopleAdapter
import com.example.desafiofluxkotlin.people.adapters.PeopleItemListener
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.people.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : AppCompatActivity(), PeopleItemListener {

    @Inject
    lateinit var peopleViewModel: PeopleViewModel

    val QUANTITY: Int = 20
    lateinit var adapter : PeopleAdapter

    init {
        DaggerPeopleInjector.create().apply { inject(this@MainActivity) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            viewModel = peopleViewModel
            executePendingBindings()
            lifecycleOwner = this@MainActivity
        }
        binding.viewModel?.getPeople(QUANTITY)

        setUpObserver(binding)
        setUpRecyclerView(binding)
        swipeRefresh.setOnRefreshListener { binding.viewModel?.getPeople(QUANTITY) }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        setUpSearchView(searchItem)
        return true
    }

    override fun onItemClick(people: People.ResultsBean) {
        people.name?.first?.let { toast(it) }
    }

    private fun setUpSearchView(searchItem: MenuItem) {
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filterPeople(newText)
                return false
            }
        })
    }

    private fun setUpObserver(binding: ActivityMainBinding) {
        binding.viewModel?.message?.observe(this, Observer {
            it?.let { it1 -> toast(it1) }.also {
                loading.hide()
                swipeRefresh.isRefreshing = false
            }
        })
    }

    private fun setUpRecyclerView(binding: ActivityMainBinding) {
        recyclerPeople.setHasFixedSize(true)
        recyclerPeople.layoutManager = LinearLayoutManager(this)
        binding.viewModel?.peopleList?.observe(this, Observer {
            adapter = it?.results?.let { it1 -> PeopleAdapter(it1, this) }!!
            recyclerPeople.adapter = adapter
        })
    }

}
