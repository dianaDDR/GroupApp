package com.example.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ReservasRealizadas : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reservasrealizadas)
    }
    fun atras (view:android.view.View){
        onBackPressed()
    }

}