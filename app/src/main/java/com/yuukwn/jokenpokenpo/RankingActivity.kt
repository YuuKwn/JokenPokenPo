package com.yuukwn.jokenpokenpo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yuukwn.jokenpokenpo.api.JokenpokemonAPI
import com.yuukwn.jokenpokenpo.model.Pontuacao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)


        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(JokenpokemonAPI::class.java!!)

        service.buscarPontuacao()
                .enqueue(object : Callback<List<Pontuacao>> {
                    override fun onFailure(call: Call<List<Pontuacao>>?, t: Throwable?) {
                        Log.i("Erro", "Deu ruim")
                    }

                    override fun onResponse(call: Call<List<Pontuacao>>?, response: Response<List<Pontuacao>>?) {
                        val pontuacao = response?.body()
                        for(pont in pontuacao!!) {
                            Log.i("PONTUACAO", "${pont.nome} - ${pont.pontos}")
                        }
                    }
                })
}

}