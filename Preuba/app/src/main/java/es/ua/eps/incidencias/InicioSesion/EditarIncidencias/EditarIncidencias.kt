package es.ua.eps.incidencias.InicioSesion.EditarIncidencias

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import es.ua.eps.incidencias.InicioSesion.CrearIncidencia.CrearIncidenciaTipo
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.Incidencia
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaProvider
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.InicioSesion.InicioSesion
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityEditarIncidenciasBinding

class EditarIncidencias : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener  {
    var InciIndex = 0
    private lateinit var incidencia: Incidencia
    lateinit var binding : ActivityEditarIncidenciasBinding

    //para ele menu drawer
    private lateinit var  drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarIncidenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        incidencia = intent.extras?.get("incidencia") as Incidencia
        var num = intent.getIntExtra("numOpcion",0)
        cargarDatos(incidencia)
        cargarToolbar()

        when (num){
           0 -> {
               binding.etxtComentario.isEnabled = true
            }

            1->{
                binding.etxtmDescripcion.isEnabled = false
            }
        }
        binding.imgAceptar.setOnClickListener(){
            guardarCambios(incidencia)
        }

        binding.imgCancelar.setOnClickListener(){
            volverParaAtras()
        }
    }

    fun cargarDatos(incidencia: Incidencia){
        binding.txtAulaYorde.text = "Aula: ${incidencia.aula}  equipo: ${incidencia.equipo}"
        binding.etxtmDescripcion.setText(incidencia.descripcion)
    }

    fun cargarToolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout_editar)

        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }


    private fun guardarCambios(incidencia: Incidencia){
        var comen = binding.etxtComentario.text.toString()
        incidencia.addComentario(comen)
        incidencia.descripcion = binding.etxtmDescripcion.text.toString()
        volverParaAtras()
    }

    private fun volverParaAtras(){
        val intent = Intent(this, IncidenciaResuminda::class.java)
        startActivityForResult(intent, IncidenciaResuminda.REQUEST_CODE)
        startActivity(intent)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_resumen -> Resumen()
            R.id.nav_anaidir -> Anaidir()
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

    fun Anaidir(){
        val intent = Intent(this, CrearIncidenciaTipo::class.java)
        startActivity(intent)
    }

    fun Resumen(){
        val intent = Intent(this, IncidenciaResuminda::class.java)
        startActivity(intent)
    }

    fun CerrarSesion(){
        val intent = Intent(this, InicioSesion::class.java)
        startActivity(intent)
    }
}