package es.ua.eps.incidencias.InicioSesion.CrearIncidencia

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.InicioSesion.InicioSesion
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityCrearIncidenciaBinding

class CrearIncidencia : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityCrearIncidenciaBinding

    //para ele menu drawer
    private lateinit var  drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearIncidenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarToolbar()
        binding.txtVerTipo.text = intent.extras?.get("cadena") as String

        // Encuentra la referencia al botón de menú en el layout activity_incidencia_resumida.xml
        val botonOtroLayout: ImageView = findViewById(R.id.btnmenu)

        // Agrega un listener de clic al botón de menú
        botonOtroLayout.setOnClickListener {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                drawer.openDrawer(GravityCompat.START)
            }
        }

        binding.btnCrearGuardar.setOnClickListener(){

        }

        binding.btnCrearCancelar.setOnClickListener(){
            IncidenciaResuminda()
        }




    }
    fun cargarToolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout_crear)

        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }
    fun IncidenciaResuminda(){
        val intent3 = Intent(this, IncidenciaResuminda::class.java)
        startActivity(intent3)
    }

    fun CerrarSesion(){
        val intent = Intent(this, InicioSesion::class.java)
        startActivity(intent)
    }

    fun MensajeAnaidir(){
            // Crear el cuadro de diálogo
            val builder = AlertDialog.Builder(this)

            // Establecer el mensaje del cuadro de diálogo
            builder.setMessage("Estas ya en esta pagina")

            // Configurar el botón "Aceptar" con un fondo de color personalizado
            builder.setPositiveButton("Aceptar") { dialog, id ->
                // Puedes agregar acciones adicionales al hacer clic en Aceptar si es necesario
                dialog.dismiss()
            }

            // Mostrar el cuadro de diálogo
            val alertDialog = builder.create()
            alertDialog.setOnShowListener {
                val positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                positiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            }
            alertDialog.show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_resumen -> IncidenciaResuminda()
            R.id.nav_anaidir -> MensajeAnaidir()
            R.id.nav_vertodo ->  Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_cerrarSesion -> CerrarSesion()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
