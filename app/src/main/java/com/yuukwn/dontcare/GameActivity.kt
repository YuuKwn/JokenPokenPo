package com.yuukwn.dontcare

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

    private var Pontos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        numeroRandom = Random()

        Pedra.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gentlemander))
            realizarJogada(PEDRA)
        }

        Papel.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.squirtle))
            realizarJogada(PAPEL)
        }

        Tesoura.setOnClickListener{
            JogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bulbaman))
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
                JogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.squirtle))
                when (jogadaPlayer){
                    PAPEL -> empatou()
                    PEDRA -> perdeu()
                    TESOURA -> venceu()
                }
            }

            TESOURA -> {
                JogadaPC!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bulbaman))
                when (jogadaPlayer){
                    PAPEL -> venceu()
                    PEDRA -> perdeu()
                    TESOURA -> empatou()
                }
            }
        }
    }

    private fun venceu(){
        Pontos = Pontos+2
        Score.text = Pontos.toString()
    }


    private fun empatou(){
        Pontos = Pontos+1
        Score.text = Pontos.toString()
    }


    private fun perdeu(){
    intent = Intent(this, OverActivity::class.java)
        intent.putExtra("Points", Pontos)
        startActivity(intent)

    }
}
