package es.ua.eps.incidencias.InicioSesion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityIniciosesionBinding

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etxtEscribir.hint= "Introduce el correo"
        binding.etxtPescribir.hint="Contraseña"
        binding.btnIniciarSesion.setOnClickListener(){
            var vali = validar()
            if (vali == true) {
                val intent2 = Intent(this, IncidenciaResuminda::class.java)
                startActivity(intent2)
            } else {
                camposVacios("El usuario  o la contraseña esta vacio")
            }
        }
    }


    fun validar():Boolean{
        var validar = true
        var nom  = findViewById(R.id.etxtEscribir) as EditText
        var contra = findViewById(R.id.etxtPescribir) as EditText

        var nombres = nom.text.toString()
        var co = contra.text.toString()

        if(nombres.isEmpty()){
            validar = false
        }

        if(co.toString().isEmpty()){
            validar = false
        }
        return validar
    }
    private fun camposVacios(cadena:String) {
        // Crear el cuadro de diálogo
        val builder = AlertDialog.Builder(this)

        // Establecer el mensaje del cuadro de diálogo
        builder.setMessage(cadena)

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