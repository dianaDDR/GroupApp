package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class Reserva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reserva)

        val textviewID: TextView = findViewById(R.id.etDate)
        textviewID.setOnClickListener() { showDatePickerDialog() }
        val textViewTime: TextView = findViewById(R.id.etTime)
        textViewTime.setOnClickListener() { showTimePickerDialog() }
    }


    private fun showDatePickerDialog() {
        val datePicker =
            DataPickerFragment({ day, month, year -> onDateSelected(day, month, year) })
        datePicker.show(supportFragmentManager, "data")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        val textviewID: TextView = findViewById(R.id.etDate)
        textviewID.setText("has seleccionado el día $day  del mes $month de $year")
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { onTimeSelected(it) }
        timePicker.show(supportFragmentManager, "time")

    }

    private fun onTimeSelected(time: String) {
        val textViewTime: TextView = findViewById(R.id.etTime)
        textViewTime.setText("has seleccionado las $time")

    }



}
