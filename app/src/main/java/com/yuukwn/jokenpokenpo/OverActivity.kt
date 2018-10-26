package com.yuukwn.jokenpokenpo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yuukwn.jokenpokenpo.api.JokenpokemonAPI
import com.yuukwn.jokenpokenpo.model.Pontuacao
import kotlinx.android.synthetic.main.activity_over.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
class OverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over)


        btnPlayAgain.setOnClickListener(){
           val pontuacao = Pontuacao(tvNome.text.toString(), Score.toString().toInt())
            getJkenPokemonAPI()
                    .salvarPontos(pontuacao)
                    .enqueue(object: Callback<Void>{
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {

                        }

                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

                        }
                    })
        }
    }

    private fun getJkenPokemonAPI() : JokenpokemonAPI{
        val retrofit = Retrofit.Builder()
                .baseUrl("http://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
                .create<JokenpokemonAPI>(JokenpokemonAPI::class.java!!)
    }

    private fun msgSuccess(){
        Toast.makeText(this, "NÃO FOI", Toast.LENGTH_LONG).show()

    }

    private fun msgFail(){
        Toast.makeText(this, "FOI", Toast.LENGTH_LONG).show()

    }
}
*/
class OverActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over)
        val bundle = intent.extras!!
        val Pontinhos = bundle.getInt("Pontinhos")


        btnPlayAgain.setOnClickListener(){
        val pontuacao = Pontuacao(etNome.text.toString(), Pontinhos)
            getJokenPokemonAPI()
                    .salvarPontos(pontuacao)
                    .enqueue(object : Callback<Void> {
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            exibirMensagemErro()
                        }

                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            if (response?.isSuccessful == true) {
                                exibirMensagemSucesso()

                            } else {
                                exibirMensagemErro()
                            }
                        }
                    })
            intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        btnMenu.setOnClickListener(){
            val pontuacao = Pontuacao(etNome.text.toString(), Pontinhos)
            getJokenPokemonAPI()
                    .salvarPontos(pontuacao)
                    .enqueue(object : Callback<Void> {
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            exibirMensagemErro()
                        }

                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            if (response?.isSuccessful == true) {
                                exibirMensagemSucesso()

                            } else {
                                exibirMensagemErro()
                            }
                        }
                    })
            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        }


    private fun exibirMensagemSucesso() {
        Toast.makeText(this, "Gravado", Toast.LENGTH_LONG).show()
    }

    private fun exibirMensagemErro() {
        Toast.makeText(this, "Deu erro", Toast.LENGTH_LONG).show()
    }


    private fun getJokenPokemonAPI(): JokenpokemonAPI {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
                .create<JokenpokemonAPI>(JokenpokemonAPI::class.java)
    }
}