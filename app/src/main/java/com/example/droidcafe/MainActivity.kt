package com.example.droidcafe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Dados()
    }

    private fun Dados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.adquirirSobremesa()?.enqueue(object : Callback<List<Sobremesa>> {
            override fun onResponse(call: Call<List<Sobremesa>?>?, response: Response<List<Sobremesa>?>?) {
                val lista = response?.body();
                if (lista != null) {
                    for (sobremesa in lista) {
                    }

                    text1.text = lista?.get(0).descricao
                    text2.text = lista?.get(1).descricao
                    text3.text = lista?.get(2).descricao

                    quantidade1.text = lista?.get(0).valor
                    quantidade2.text = lista?.get(1).valor
                    quantidade3.text = lista?.get(2).valor

                }
            }

            override fun onFailure(call: Call<List<Sobremesa>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })
    }

}