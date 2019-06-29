package com.example.desafiofluxkotlin.person_location.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.desafiofluxkotlin.R
import com.example.desafiofluxkotlin.people.model.People
import com.example.desafiofluxkotlin.person_detail.view.PersonDetailActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class PersonLocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var person: People.ResultsBean
    val SPACE: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        person = intent.getParcelableExtra(PersonDetailActivity.EXTRA_PERSON)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun setToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = person.name?.first.plus(SPACE).plus(getString(R.string.location))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude = person.location?.coordinates?.latitude?.toDouble()
        val longitude = person.location?.coordinates?.longitude?.toDouble()
        val location = LatLng(latitude!!, longitude!!)
        mMap.addMarker(MarkerOptions().position(location).title(person.name?.first))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))

    }
}
