package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_API)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


    }
}