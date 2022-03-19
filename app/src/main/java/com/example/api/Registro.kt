package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }

    fun setBottom(){
        val Nombre : TextInputEditText = findViewById(R.id.textFieldNombre);
        val Apellido : TextInputEditText = findViewById(R.id.textFieldApellido);
        val Email : TextInputEditText = findViewById(R.id.textFieldEmail);
        val Passwd : TextInputEditText = findViewById(R.id.textFieldContrasena);
        val Passwd2 : TextInputEditText = findViewById(R.id.textFieldConfirmaContrasena);

        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios").document(Email.text.toString()).set(hashMapOf(
            "Nombre" to Nombre.text.toString(),
            "Apellido" to Apellido.text.toString(),
            "Passwd" to Passwd.text.toString(),
            "Passwd2" to Passwd2.text.toString()
        ))
    }

    fun onclickAtrasRegistro(view: View) {
        onBackPressed()
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error con firebase")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun irPantallaMenu() {
        var menuIntent = Intent(this, Menu::class.java)
        startActivity(menuIntent)
    }

    fun onClickConfirmar(view:View) {

        val email: TextInputEditText = findViewById(R.id.textFieldEmail);
        val cont: TextInputEditText = findViewById(R.id.textFieldContrasena);
        val cont2: TextInputEditText = findViewById(R.id.textFieldConfirmaContrasena)

        if (email != null && cont != null && cont2!=null) {
            if (email.text.toString() != "" && cont.text.toString() != "") {
                var emailString = email.text.toString()
                var contString = cont.text.toString()
                var cont2String = cont2.text.toString()

                if ( contString == cont2String) {

                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(emailString, contString)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                setBottom()
                                irPantallaMenu()

                            } else {
                                showError()
                            }
                        }

                }else{
                    showError()
                }
            }
        } else {

        }
        //Se realizara cuando se presione el boton NEXT

        //Intent es una clase que recibe 2 parametros, donde estamos y a donde vamos

        //Creamos un objeto de la clase Intent

    }

}