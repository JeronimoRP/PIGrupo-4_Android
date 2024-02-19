package es.ua.eps.incidencias.InicioSesion.EditarIncidencias

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.Incidencia
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaProvider
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityEditarIncidenciasBinding

class EditarIncidencias : AppCompatActivity() {
    var InciIndex = 0
    private lateinit var incidencia: Incidencia
    lateinit var binding : ActivityEditarIncidenciasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarIncidenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        incidencia = intent.extras?.get("incidencia") as Incidencia
        var num = intent.getIntExtra("numOpcion",0)
        cargarDatos(incidencia)

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
    }

    fun cargarDatos(incidencia: Incidencia){
        binding.txtAulaYorde.text = "Aula: ${incidencia.aula}  equipo: ${incidencia.equipo}"
        binding.etxtmDescripcion.setText(incidencia.descripcion)
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
}