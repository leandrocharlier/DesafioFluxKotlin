package com.example.desafiofluxkotlin.person_detail.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ResourceModule(var context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

}