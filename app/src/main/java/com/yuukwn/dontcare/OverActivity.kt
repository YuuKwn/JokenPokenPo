package com.yuukwn.dontcare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yuukwn.dontcare.api.JokenpokemonAPI
import com.yuukwn.dontcare.model.Pontuacao
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_over.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over)


        btnPlayAgain.setOnClickListener(){
           val pontuacao = Pontuacao(tvNome.text.toString(), Score.toString())
            getJkenPokemonAPI()
                    .salvarPontos(pontuacao : )
        }
    }

    private fun getJkenPokemonAPI() : JokenpokemonAPI{
        val retrofit = Retrofit.Builder()
                .baseUrl("http://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
                .create<JokenpokemonAPI>(JokenpokemonAPI::class.java)
    }
}
