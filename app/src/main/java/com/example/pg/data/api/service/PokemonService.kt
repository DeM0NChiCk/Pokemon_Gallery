package com.example.pg.data.api.service

import com.example.pg.BuildConfig
import com.example.pg.BuildConfig.POCEMON_API_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonService {
    private val okHttpClient: OkHttpClient by lazy {
        provideOkHttpClient()
    }
    private val retrofitInstance: PokemonApiService by lazy {
        createRetrofitInstance()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor{ chain ->
                val request = chain.request().newBuilder().build()

                chain.proceed(request)
            }

        if (BuildConfig.DEBUG) {
            client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return client.build()
    }

    private fun createRetrofitInstance(): PokemonApiService {


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(POCEMON_API_URL)
            .client(okHttpClient ?: OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitBuilder.create(PokemonApiService::class.java)
    }

    fun getInstance(): PokemonApiService = retrofitInstance
}