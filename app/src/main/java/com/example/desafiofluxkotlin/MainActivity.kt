package com.example.desafiofluxkotlin

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.desafiofluxkotlin.databinding.ActivityMainBinding
import com.example.desafiofluxkotlin.persona.viewmodel.PersonaViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var personaViewModel: PersonaViewModel

    init {
        DaggerPersonaInjector.create().apply { inject(this@MainActivity) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel = personaViewModel
            executePendingBindings()
            lifecycleOwner = this@MainActivity
        }
        binding.viewModel?.getPersonas(1)
        binding.viewModel?.mensajeError?.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


    }


}
