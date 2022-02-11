package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.api.databinding.ActivityLogInBinding
import com.example.api.databinding.ActivityMapsBinding

class LogIn : AppCompatActivity() {

        //Inflamos el XML
    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_API)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


    binding = ActivityLogInBinding.inflate(layoutInflater)

        //Botón de los 2 inputLayout (Email y Contraseña)
        binding.botonInicioSesion.setOnClickListener{
            val email = binding.textFieldEmail.editText?.text.toString()
            val contrasenia = binding.textFieldContrasena.editText?.text.toString()

            //El Toast nos muestra el email y la contraseña introducidas en un mensaje en el footer.
            Toast.makeText(this, "Email->$email , contrasena-> $contrasenia",Toast.LENGTH_LONG).show()
        }
        setContentView(binding.root)

    }
}