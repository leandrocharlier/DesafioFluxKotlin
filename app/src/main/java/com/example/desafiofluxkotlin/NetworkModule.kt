package com.example.desafiofluxkotlin

import com.example.desafiofluxkotlin.people.network.PeopleService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    val BASE_URL = "https://randomuser.me/api/"

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePeopleService(retrofit: Retrofit): PeopleService {
        return retrofit.create(PeopleService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}