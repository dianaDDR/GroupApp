package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReseñasA : RecyclerView.Adapter<ReseñasA.ViewHolder>(){
    var contactos : MutableList<Reseñas> = ArrayList()
    lateinit var context: Context
    fun ReseñasA(contactos: MutableList<Reseñas>, context: Context){

        this.contactos = contactos
        this.context= context
    }
    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val restau : TextView
        val nombre: TextView
        val desc : TextView


        init {
            restau=view.findViewById(R.id.textView8)
            nombre=view.findViewById(R.id.textView9)
            desc=view.findViewById(R.id.textView10)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = contactos[position].nombre
    }

    override fun getItemCount() = contactos.size


}