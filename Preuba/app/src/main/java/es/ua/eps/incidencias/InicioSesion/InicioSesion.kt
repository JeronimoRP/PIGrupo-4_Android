package es.ua.eps.incidencias.InicioSesion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.incidencias.databinding.ActivityIniciosesionBinding

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicioEducantabria.setOnClickListener(){
            //Llamamos al metodo navegar para ir a datos inicio sesion
          NavegarDatosInicioSesion("1")
        }
        binding.btnInicioSesionDominio.setOnClickListener(){
            //Llamamos al metodo navegar para ir a datos inicio sesion
            NavegarDatosInicioSesion("2")
        }
    }

    fun NavegarDatosInicioSesion(opcion :String){
        val intent = Intent(this, DatosInicioSesion::class.java)
        intent.putExtra("codigo",opcion)
        startActivity(intent)
    }
}