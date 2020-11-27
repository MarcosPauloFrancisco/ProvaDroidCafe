package com.example.droidcafe

import retrofit2.Call
import retrofit2.http.GET


interface EndPoint {
    @GET("droidcafe")
    fun adquirirSobremesa(): Call<List<Sobremesa>>

}