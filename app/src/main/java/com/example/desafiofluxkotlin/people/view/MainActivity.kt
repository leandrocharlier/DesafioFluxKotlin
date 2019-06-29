package com.example.desafiofluxkotlin.people.view

import android.app.ActivityOptions
import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.databinding.ActivityMainBinding
import com.example.desafiofluxkotlin.people.MyQueryTextListener
import com.example.desafiofluxkotlin.people.adapters.EndlessScrollListener
import com.example.desafiofluxkotlin.people.adapters.PeopleAdapter
import com.example.desafiofluxkotlin.people.adapters.PeopleItemListener
import com.example.desafiofluxkotlin.people.di.DaggerPeopleComponent
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.person_detail.view.PersonDetailActivity
import com.example.desafiofluxkotlin.people.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PeopleItemListener {

    val QUANTITY: Int = 20

    @Inject
    lateinit var peopleViewModel: PeopleViewModel

    var viewModel: PeopleViewModel? = null
    var adapter: PeopleAdapter? = null

    init {
        DaggerPeopleComponent.builder().build().inject(this)
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
        this.viewModel = binding?.viewModel
        viewModel?.getPeople(QUANTITY)

        setMessageObserver()
        setRecyclerView()
        setInfiniteScroll(true)
        swipeRefresh.setOnRefreshListener { viewModel?.getPeople(QUANTITY) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        setSearchView(searchItem)
        return true
    }

    override fun onItemClick(person: People.ResultsBean, personLogo : ImageView) {
        val intent = Intent(this, PersonDetailActivity::class.java)
        intent.putExtra(PersonDetailActivity.EXTRA_PERSON, person)
        intent.putExtra(PersonDetailActivity.EXTRA_PERSON_LOGO_TRANSITION_NAME, ViewCompat.getTransitionName(personLogo))
        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, personLogo, ViewCompat.getTransitionName(personLogo))
        startActivity(intent, options.toBundle())
    }

    private fun setSearchView(searchItem: MenuItem) {
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : MyQueryTextListener(), SearchView.OnQueryTextListener {
            override fun onSearch(text: String) {
                setInfiniteScroll(text.isEmpty())
                viewModel?.filterPeople(text)?.let { adapter?.updatePeople(it) }
            }
        })
    }

    private fun setMessageObserver() {
        viewModel?.message?.observe(this, Observer {
            it?.let { it1 -> toast(it1) }.also {
                hideLoading()
            }
        })
    }

    private fun setRecyclerView() {
        adapter = PeopleAdapter(this)
        recyclerPeople.adapter = adapter
        viewModel?.peopleList?.observe(this, Observer {
            it?.results?.let { it1 -> adapter?.updatePeople(it1) }
            hideLoading()
        })
    }

    private fun setInfiniteScroll(activated: Boolean) {
        adapter?.setLoading(activated)
        if (activated) {
            recyclerPeople.addOnScrollListener(object : EndlessScrollListener() {
                override fun onLoadMore() {
                    viewModel?.peopleList?.value?.info?.seed?.let { viewModel?.getPeopleWithSeed(QUANTITY, it) }
                }
            })
        } else recyclerPeople.clearOnScrollListeners()
    }

    private fun hideLoading() {
        loading.hide()
        swipeRefresh.isRefreshing = false
    }
}
