package com.example.groupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun commitButton(view: android.view.View) {
        commitActivity()
    }
    private fun commitActivity() {
        val IntComm = Intent(this, Activitycommit::class.java)
        startActivity(IntComm)
    }
}