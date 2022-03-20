package com.example.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReseñasAdapter:AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_cuenta2)

            val recycler : RecyclerView = findViewById(R.id.Rese)
            recycler.layoutManager = LinearLayoutManager(this)


            val adapter : ReseñasA = ReseñasA()
            //Configuración Adapter
            adapter.ReseñasA(contacts(), this)

            //Configuración RecyclerView
            recycler.hasFixedSize()
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = adapter
        }

        private fun contacts(): MutableList<Reseñas> {

            var contactos : MutableList<Reseñas> = ArrayList()
            contactos.add(Reseñas("Cafeoasis", "@Alex940", "Muy bueno"))
            contactos.add(Reseñas("Cafeoasis", "@Alex940", "Muy bueno"))
            contactos.add(Reseñas("Cafeoasis", "@Alex940", "Muy bueno"))
            contactos.add(Reseñas("Cafeoasis", "@Alex940", "Muy bueno"))

            return contactos
        }
    }
