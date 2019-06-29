package com.example.desafiofluxkotlin.person_detail.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.databinding.ActivityPeopleDetailBinding
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.person_detail.MyGlideRequestListener
import com.example.desafiofluxkotlin.person_detail.di.DaggerPersonComponent
import com.example.desafiofluxkotlin.person_detail.di.PersonModule
import com.example.desafiofluxkotlin.person_detail.di.ResourceModule
import com.example.desafiofluxkotlin.person_detail.viewmodel.PersonDetailViewModel
import com.example.desafiofluxkotlin.person_location.view.PersonLocationActivity
import kotlinx.android.synthetic.main.activity_people_detail.*
import kotlinx.android.synthetic.main.persona_item.personLogo
import javax.inject.Inject

class PersonDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var personDetailViewModel: PersonDetailViewModel

    companion object {
        const val EXTRA_PERSON = "extraPerson"
        const val EXTRA_PERSON_LOGO_TRANSITION_NAME = "extraTransitionName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val person: People.ResultsBean = intent.getParcelableExtra(EXTRA_PERSON)
        val transitionName: String = intent.getStringExtra(EXTRA_PERSON_LOGO_TRANSITION_NAME)
        DaggerPersonComponent.builder()
            .personModule(PersonModule(person))
            .resourceModule(ResourceModule(applicationContext))
            .build()
            .inject(this)
        DataBindingUtil.setContentView<ActivityPeopleDetailBinding>(this, R.layout.activity_people_detail).apply {
            viewModel = personDetailViewModel
            executePendingBindings()
            lifecycleOwner = this@PersonDetailActivity
        }

        supportPostponeEnterTransition()
        personLogo.transitionName = transitionName
        loadPersonLogo(person)
        setToolbar(person)
        buttonLocation.setOnClickListener { goToLocation(person) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setToolbar(person: People.ResultsBean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = person.login?.username
    }

    fun loadPersonLogo(person: People.ResultsBean) {
        Glide.with(this)
            .load(person.picture?.large)
            .listener(object : MyGlideRequestListener() {
                override fun onImageLoadComplete() {
                    supportStartPostponedEnterTransition()
                }
            })
            .into(personLogo)
    }

    fun goToLocation(person: People.ResultsBean) {
        val intent = Intent(this, PersonLocationActivity::class.java)
        intent.putExtra(EXTRA_PERSON, person)
        startActivity(intent)
    }

}
