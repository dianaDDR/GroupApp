package com.example.api

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.api.databinding.ActivityMenuBinding
import com.google.firebase.auth.FirebaseAuth

class Menu : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMenu.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.cuenta, R.id.feed, R.id.cerrar, R.id.home, R.id.ajustes, R.id.restaurantes, R.id.reservas, R.id.etiquetas, R.id.premium
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_menu)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun onClickNext(view: android.view.View) {
        val nextIntent = Intent(this, MapsActivity::class.java)
        startActivity(nextIntent)
    }

    fun onClickCeliaco(view: android.view.View) {
        // marcador cerca de mi, google maps, filtro restaurantes
        val gmmIntentUri = Uri.parse("geo:0,0?q=restaurantes celíacos")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    fun onClickVegano(view: android.view.View) {
        // marcador cerca de mi, google maps, filtro restaurantes
        var gmmIntentUri = Uri.parse("geo:0,0?q=restaurantes veganos")
        var mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
 /*   //cerrar sesion y vuelva a login
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId
        if(item_selected == R.id.cerrar)
        {
            FirebaseAuth.getInstance().signOut();
            val nextIntent = Intent(this, LogIn::class.java)
            startActivity(nextIntent)
        }
        else {
            //error
        }
        return super.onOptionsItemSelected(item)
    }
*/
}