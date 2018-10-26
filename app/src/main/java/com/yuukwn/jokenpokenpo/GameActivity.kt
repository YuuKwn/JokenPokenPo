package com.yuukwn.jokenpokenpo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {
    private var numeroRandom: Random? =null

    private val PEDRA = 1
    private val PAPEL = 2
    private val TESOURA = 3
    private var Vidas = 3



    private var Pontos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        tvVidas.text = Vidas.toString()

        numeroRandom = Random()

        Pedra.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentlemander))
            realizarJogada(PEDRA)
        }

        Papel.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentletle))
            realizarJogada(PAPEL)
        }

        Tesoura.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentlesaur))
            realizarJogada(TESOURA)
        }
    }





    private fun realizarJogada(jogadaPlayer: Int){
        val jogadaPC = numeroRandom!!.nextInt(3)+1
        when(jogadaPC){
            PEDRA -> {
                JogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentlemander))
                when (jogadaPlayer){
                    PAPEL -> venceu()
                    PEDRA -> empatou()
                    TESOURA -> perdeu()
                }
            }

            PAPEL -> {
                JogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentletle))
                when (jogadaPlayer){
                    PAPEL -> empatou()
                    PEDRA -> perdeu()
                    TESOURA -> venceu()
                }
            }

            TESOURA -> {
                JogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentlesaur))
                when (jogadaPlayer){
                    PAPEL -> venceu()
                    PEDRA -> perdeu()
                    TESOURA -> empatou()
                }
            }
        }
    }

    private fun venceu(){
        Pontos = Pontos+2000
        Score.text = Pontos.toString()
    }


    private fun empatou(){
        Pontos = Pontos+1000
        Score.text = Pontos.toString()
    }


    private fun perdeu(){

        Vidas = Vidas - 1
        tvVidas.text = Vidas.toString()
        if(Vidas == 0){
    intent = Intent(this, OverActivity::class.java)
        intent.putExtra("Pontinhos", Pontos)
        startActivity(intent)
        finish()}


    }
}
