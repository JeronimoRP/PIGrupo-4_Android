package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityIncidenciaSecundariaBinding

class IncidenciaSecundaria : AppCompatActivity() {
    lateinit var binding : ActivityIncidenciaSecundariaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncidenciaSecundariaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //creamos los datos osea una kotlin clases nuevas Disco
        binding.rvIncidencias.layoutManager = LinearLayoutManager(this)
        //Ahora le damos el adapter y si quieres le pones la funciona
        binding.rvIncidencias.adapter = IncidenciaAdaptador(IncidenciaProvider.incidenciaList)
    }

}