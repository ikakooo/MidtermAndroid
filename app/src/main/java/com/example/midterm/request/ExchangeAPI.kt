package com.example.midterm.request

import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import retrofit2.Call
import retrofit2.http.GET

//private const val EXCHANGE_API2 = "https://api.exchangeratesapi.io/"


interface ExchangeAPI {
    @GET("latest")
    fun getJSonRequest(): Call<ExchangeRatesJsonModel>


}