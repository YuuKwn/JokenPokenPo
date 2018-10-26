package com.yuukwn.jokenpokenpo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val time = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Load()
    }

    fun Load(){
        val anim = AnimationUtils.loadAnimation(this,R.anim.animation)
        anim.reset()
        ivSplash!!.clearAnimation()
        ivSplash!!.startAnimation(anim)

        Handler().postDelayed({
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            this.finish()
        }, time)
    }
}
