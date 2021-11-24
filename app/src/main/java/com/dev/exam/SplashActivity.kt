package com.dev.exam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dev.exam.databinding.ActivitySplashBinding

class SplashActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler = Handler()
        handler.postDelayed({
            goToMain()
        }, 3000)

    }
    fun goToMain(){

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()

    }

}