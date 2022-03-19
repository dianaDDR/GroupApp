package com.example.api

import android.content.Context
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    var contactos : MutableList<Modelo> = ArrayList()
    lateinit var context: Context
    fun RecyclerViewAdapter(contactos: MutableList<Modelo>, context:Context){

        this.contactos = contactos
        this.context= context
    }
    class ViewHolder(view : View):RecyclerView.ViewHolder(view){

        val nombre:TextView

        init {
            nombre=view.findViewById(R.id.textView4)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = contactos[position].nombre
    }

    override fun getItemCount() = contactos.size


}