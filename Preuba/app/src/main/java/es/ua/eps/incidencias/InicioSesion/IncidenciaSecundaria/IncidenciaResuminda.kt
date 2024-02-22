package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import es.ua.eps.incidencias.InicioSesion.CrearIncidencia.CrearIncidenciaTipo
import es.ua.eps.incidencias.InicioSesion.EditarIncidencias.EditarIncidencias
import es.ua.eps.incidencias.InicioSesion.InicioSesion
import es.ua.eps.incidencias.InicioSesion.modelo.Incidencia
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityIncidenciaResumidaBinding

class IncidenciaResuminda : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
  lateinit var binding: ActivityIncidenciaResumidaBinding
    private var incidenciasMutableList: MutableList<Incidencia> =
        IncidenciaProvider.incidenciaList.toMutableList()
    private lateinit var adapter: IncidenciaAdaptador

    //para ele menu drawer
    private lateinit var  drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    //recuperar nombre
    var nombre:String = ""

    //Para llevar cosas
    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncidenciaResumidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

         cargartoolbar()

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


        //creamos los datos osea una kotlin clases nuevas Incidencias
        val rvIncidencias = findViewById<RecyclerView>(R.id.rvIncidencias)
        rvIncidencias.layoutManager = LinearLayoutManager(this)
        //Ahora le damos el adapter y si quieres le pones la funciona
        initRecycleView(rvIncidencias)



    }
    fun cargartoolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun initRecycleView(rvIncidencias: RecyclerView) {
            rvIncidencias.adapter = IncidenciaAdaptador(
            incidenciaList = incidenciasMutableList,
            onClickListener = { incidencia -> onItemSelected(incidencia) },
            onClickEliminar = { position -> onDeletedItem(position) }

        )
    }

    private fun onItemSelected(incidencia: Incidencia) {
        var num: Int = 0
        val estado = incidencia.estado
        if (estado.equals("abierta")) {
            num = 0
        } else {
            num = 1
        }

        val intent = Intent(this, EditarIncidencias::class.java)
        intent.putExtra("incidencia", incidencia)
        intent.putExtra("numOpcion", num)
        startActivityForResult(intent, REQUEST_CODE)
        startActivity(intent)
    }

    fun onDeletedItem(position: Int) {
        mensajeEliminar(position)
    }

    private fun mensajeEliminar(posicion: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Incidente")
        builder.setMessage("¿Estás seguro de que deseas eliminar este incidente?")

        builder.setPositiveButton("Aceptar") { dialog, which ->
            // Llamamos al método onDeleteConfirmed del listener para notificar que se confirmó la eliminación
            onDeleteConfirmed(posicion)
            Toast.makeText(this, "Incidente eliminado", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("Cancelar") { dialog, which ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private  fun onDeleteConfirmed(posicion: Int){
        //Hay que hacer la llama a la api y en el select poner el delete
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_resumen -> MensajeResumen()
            R.id.nav_anaidir -> CrearIncidencia()
            R.id.nav_vertodo ->  Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_cerrarSesion ->  CerrarSesion()
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

    fun CerrarSesion(){
        val intent = Intent(this, InicioSesion::class.java)
        startActivity(intent)
    }
    fun CrearIncidencia(){
        val intent = Intent(this, CrearIncidenciaTipo::class.java)
        startActivity(intent)
    }
    fun MensajeResumen(){
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
}