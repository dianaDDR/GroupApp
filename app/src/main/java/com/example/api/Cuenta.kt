package com.example.api

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_cuenta)

        val recycler : RecyclerView= findViewById(R.id.Rese)
        recycler.layoutManager = GridLayoutManager(this, 3)


        val adapter : RecyclerViewAdapter = RecyclerViewAdapter()
        //Configuración Adapter
        adapter.RecyclerViewAdapter(contacts(), this)

        //Configuración RecyclerView
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    private fun contacts(): MutableList<Modelo> {

        var contactos : MutableList<Modelo> = ArrayList()
        contactos.add(Modelo("Ale" , R.drawable.fondo2))
        contactos.add(Modelo("Ale" , R.drawable.fondo2 ))
        contactos.add(Modelo("Ale" , R.drawable.fondo2))
        contactos.add(Modelo("Ale" , R.drawable.fondo2 ))

        return contactos
    }

    fun irPantallaResena(view: android.view.View) {
        val inicioIntent = Intent(this,ReseñasAdapter::class.java)
        startActivity(inicioIntent)
    }
}