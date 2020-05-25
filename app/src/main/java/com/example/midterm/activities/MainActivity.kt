package com.example.midterm.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.R
import com.example.midterm.request.ExchangeAPI
import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val EXCHANGE_API = "https://api.exchangeratesapi.io/"

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.exchangeratesapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val postsApi = retrofit.create(ExchangeAPI::class.java)
    private val jsonVariables = postsApi.getJSonRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        buttonID.setOnClickListener() {
            //
            jsonVariables.enqueue(object : Callback<ExchangeRatesJsonModel> {
                override fun onFailure(call: Call<ExchangeRatesJsonModel>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<ExchangeRatesJsonModel>, response: Response<ExchangeRatesJsonModel>
                ) {
                    val mResponse = jsonVariables.execute().body()
                    textViewID.text = mResponse!!.rates!!.USD.toString()
                }

            })
        }
    }
}
