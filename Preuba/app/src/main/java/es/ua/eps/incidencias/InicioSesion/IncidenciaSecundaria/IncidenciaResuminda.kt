package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import es.ua.eps.incidencias.InicioSesion.EditarIncidencias.EditarIncidencias
import es.ua.eps.incidencias.databinding.ActivityIncidenciaSecundariaBinding

class IncidenciaResuminda : AppCompatActivity() {
    lateinit var binding : ActivityIncidenciaSecundariaBinding

    //Para llevar cosas
    companion object {
        const val REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncidenciaSecundariaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //creamos los datos osea una kotlin clases nuevas Disco
        binding.rvIncidencias.layoutManager = LinearLayoutManager(this)
        //Ahora le damos el adapter y si quieres le pones la funciona
        binding.rvIncidencias.adapter = IncidenciaAdaptador(IncidenciaProvider.incidenciaList){
            onItemSelected(it)
        }

    }

    private  fun onItemSelected(incidencia: Incidencia){
        val intent = Intent(this, EditarIncidencias::class.java)
        intent.putExtra("cancion",incidencia)
        startActivityForResult(intent, REQUEST_CODE)
        startActivity(intent)
    }
}