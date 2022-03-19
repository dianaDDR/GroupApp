package com.example.api

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.api.databinding.ActivityLogInBinding
import com.example.api.databinding.ActivityMapsBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignIn.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LogIn : AppCompatActivity() {
    private val GOOGLE_SIGN_CODE=100

    //Inflamos el XML
   //private lateinit var binding: ActivityLogInBinding

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_API)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Para ver los loggin en la consola de Firebase
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Mensaje", "Firebase tutorial")
        analytics.logEvent("InitScreen", bundle)
        google()
        comprobarSesion()

        // función para comprobar si ya hay un usuario logueado

        //google
        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleClient = getClient(this, googleConf)


        val registerButton : ImageButton = findViewById(R.id.botonGoogleLogin);
        registerButton.setOnClickListener{
            googleClient.signOut()
            val intent = googleClient.getSignInIntent()
            startActivityForResult(intent, 100)
        }
    }
    /*binding = ActivityLogInBinding.inflate(layoutInflater)

        // inputLayout (Email y Contraseña)
        binding.botonInicioSesion.setOnClickListener{
            val email = binding.email.editText?.text.toString()
            val contrasena = binding.contrasena.editText?.text.toString()

            //El Toast nos muestra el email y la contraseña introducidas en un mensaje en el footer.
            Toast.makeText(this, "Email->$email , contrasena-> $contrasena",Toast.LENGTH_LONG).show()
        }
        setContentView(binding.root)*/


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_CODE) {
            val task = getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful,
                //authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                if(account != null){
                    val credential = GoogleAuthProvider.
                    getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().
                    signInWithCredential(credential)
                        .addOnCompleteListener{
                            if(it.isSuccessful){
                                // Navegamos a la siguiente
                                irPantallaMenu()
                            }
                            else{
                                 //Error
                            }
                        }
                }
            } catch (e: ApiException) {
                showError()

            }
        }
    }
    fun google(){
        val googleConf = GoogleSignInOptions.
        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
        requestIdToken(getString(R.string.default_web_client_id))
            .
            requestEmail().
            build()
        val gClient = getClient(this,
            googleConf)
        val googleButton : ImageButton = findViewById(R.id.botonGoogleLogin);
        googleButton.setOnClickListener{
            gClient.signOut()
            val intent = gClient.getSignInIntent()
            startActivityForResult(intent, 100)
        }

    }

    private fun comprobarSesion(){
        val preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE)
        // RECOGEMOS EL EMAIL
        val email = preferences.getString("email", null)
        if(email != null){
            irPantallaMenu()
        }
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error con Firebase")
        builder.setPositiveButton( "Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showErrorContraseña() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("El email o la contraseña introducida no es correcta")
        builder.setPositiveButton( "Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun irPantallaRegistro() {
        val homeIntent = Intent(this, Registro::class.java)
        startActivity(homeIntent)
    }
    fun onClickIrRegistro(view: View) {
        irPantallaRegistro()
    }
    private fun irPantallaMenu() {
        val menuIntent = Intent(this, Menu::class.java)
        startActivity(menuIntent)
    }


    fun onClickInicioSesion(view: View) {
        // Obtenemos los campos de texto y los guardamos en objetos
        val email: TextInputEditText = findViewById(R.id.email);
        val passw: TextInputEditText = findViewById(R.id.contrasena);
        // Comprobamos que los campos no son nulos
        var emailString = email.text.toString()
        var passwordString = passw.text.toString()
        if (emailString != null && passwordString != null) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        irPantallaMenu()
                    } else {
                        showErrorContraseña()
                    }
                }
        }
    }

}