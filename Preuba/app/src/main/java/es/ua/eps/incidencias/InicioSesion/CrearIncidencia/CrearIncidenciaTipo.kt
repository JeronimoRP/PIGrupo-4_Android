package es.ua.eps.incidencias.InicioSesion.CrearIncidencia

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.InicioSesion.InicioSesion
import es.ua.eps.incidencias.InicioSesion.modelo.Usuario_activo
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityCrearIncidenciaTipoBinding

class CrearIncidenciaTipo : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var usuario_activo: Usuario_activo

    lateinit var binding: ActivityCrearIncidenciaTipoBinding
    //para ele menu drawer
    private lateinit var  drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    var Tipo: String ?=null
    var tipoNombre :String ?=null
    var tipoNombreTipo:String ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearIncidenciaTipoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario_activo = intent.extras?.getSerializable("usuario") as Usuario_activo
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

        binding.btnCrearTipoGuardar.setOnClickListener(){
            var cadena :String ="${binding.spinnerTipo.getSelectedItem()},${binding.spnsubtipoNombre.getSelectedItem()}, ${binding.spnsubsubtipo.getSelectedItem()}."
            val intent = Intent(this, CrearIncidencia::class.java)
            intent.putExtra("cadena",cadena)
            startActivity(intent)
        }

        binding.btnCrearTipoCancelar.setOnClickListener(){
            Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show()
        }


        binding.spinnerTipo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Obtiene el valor seleccionado del Spinner y lo guarda en una variable
                Tipo = parent?.getItemAtPosition(position).toString()
                modificarSpinners(Tipo!!)

                // Usa el valor seleccionado como desees (por ejemplo, asignarlo a una variable)
                // Puedes utilizar 'valorSeleccionado' aquí o pasarlo a una función, etc.
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Maneja el caso cuando no se ha seleccionado ningún elemento (opcional)
            }
        }

        binding.spnsubtipoNombre.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Obtiene el valor seleccionado del Spinner y lo guarda en una variable
                tipoNombre = parent?.getItemAtPosition(position).toString()
                modificarSpinners2(tipoNombre!!)

                // Usa el valor seleccionado como desees (por ejemplo, asignarlo a una variable)
                // Puedes utilizar 'valorSeleccionado' aquí o pasarlo a una función, etc.
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Maneja el caso cuando no se ha seleccionado ningún elemento (opcional)
            }
        }

    }
    fun modificarSpinners(valor :String){
        if (valor.equals("EQUIPO")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_equipo))
            )
            binding.spnsubtipoNombre.adapter = adapter
        }

        if (valor.equals("CUENTAS")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_cuentas))
            )
            binding.spnsubtipoNombre.adapter = adapter
        }
        if (valor.equals("WIFI")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_wifi))
            )
            binding.spnsubtipoNombre.adapter = adapter
        }

        if (valor.equals("INTERNET")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_internet))
            )
            binding.spnsubtipoNombre.adapter = adapter
        }

        if (valor.equals("SOFTWARE")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_equipo))
            )
            binding.spnsubtipoNombre.adapter = adapter
        }
    }

    fun modificarSpinners2(valor:String){
        if (valor.equals("PC")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_pc))
            )
            binding.spnsubsubtipo.adapter = adapter
        }

        if (valor.equals("PORTATIL")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_portatil))
            )
            binding.spnsubsubtipo.adapter = adapter
        }

        if (valor.equals("YEDRA")){
            val adapter = ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_spinner_item,
                resources.getStringArray((R.array.tipo_nombre_array_yedra))
            )
            binding.spnsubsubtipo.adapter = adapter
        }
    }
    fun cargartoolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout_crear_tipo)

        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Obtiene la cabecera del NavigationView
        val headerView: View = navigationView.getHeaderView(0)

        // Obtén una referencia al TextView dentro de la cabecera del NavigationView
        val txtNombreHeader: TextView = headerView.findViewById(R.id.txtnombreheader)

        // Establece el nombre del usuario
        txtNombreHeader.text = usuario_activo.nombre
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_resumen -> VolverResumido()
            R.id.nav_anaidir -> MensajeResumen()
            R.id.nav_vertodo ->  Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_cerrarSesion -> CerrarSesion()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun VolverResumido(){
        val intent = Intent(this, IncidenciaResuminda::class.java)
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

    fun CerrarSesion(){
        val intent = Intent(this, InicioSesion::class.java)
        startActivity(intent)
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