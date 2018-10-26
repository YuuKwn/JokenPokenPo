package com.yuukwn.jokenpokenpo

import android.app.Application
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btJogar.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        btRanking.setOnClickListener(){
            val intent = Intent(this, RankingActivity::class.java)
            startActivity(intent)
            finish()
        }

        btSobre.setOnClickListener(){
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            finish()
        }

        btSair.setOnClickListener(){
            finish();
            System.exit(0);
        }
    }


}
