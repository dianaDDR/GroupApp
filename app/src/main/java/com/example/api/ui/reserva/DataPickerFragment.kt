package com.example.api

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.api.R
import java.time.Year
import java.util.*

class DataPickerFragment(val listener:(day: Int,month:Int,yeat:Int,) -> Unit ): DialogFragment(),
    DatePickerDialog.OnDateSetListener{
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
       listener(dayofMonth, month+1, year)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c= Calendar.getInstance()
        val day=c.get(Calendar.DAY_OF_MONTH)
        val month= c.get(Calendar.MONTH)

        val year=c.get(Calendar.YEAR)

        val picker= DatePickerDialog(activity as Context,
            R.style.datePickerThemes, this, year,month,day)
        picker.datePicker.minDate=c.timeInMillis

        return picker
    }
}