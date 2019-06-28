package com.example.desafiofluxkotlin.people.people_detail.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.people.model.People
import kotlinx.android.synthetic.main.persona_item.*

class PersonDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_PERSON = "extraPerson"
        val EXTRA_PERSON_LOGO_TRANSITION_NAME = "extraTransitionName"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_detail)
        supportPostponeEnterTransition()
        val person: People.ResultsBean = intent.getParcelableExtra(EXTRA_PERSON)
        val transitionName : String = intent.getStringExtra(EXTRA_PERSON_LOGO_TRANSITION_NAME)

        personLogo.transitionName = transitionName

        Glide.with(this)
            .load(person.picture?.large)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    supportStartPostponedEnterTransition()
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    supportStartPostponedEnterTransition()
                    return false
                }
            })
            .into(personLogo)
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
}
