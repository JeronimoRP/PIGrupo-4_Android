package es.ua.eps.incidencias.InicioSesion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import es.ua.eps.incidencias.InicioSesion.APIAccess.ApiService
import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.UsuarioResponse
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaResuminda
import es.ua.eps.incidencias.InicioSesion.modelo.Usuario_activo
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityIniciosesionBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InicioSesion : AppCompatActivity() {
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        binding.btnInicioSesion.setOnClickListener(){
            var vali = validar()
            if (vali == true) {
                val intent2 = Intent(this, IncidenciaResuminda::class.java)
                runBlocking {
                    val usuario_activo = getUsuarioActivo("edu@educantabria.es", "1234") //TODO: QUITAR HARDCODE
                    intent2.putExtra("usuario",usuario_activo)
                    startActivity(intent2)
                }
            } else {
                camposVacios("El usuario  o la contraseña esta vacio")
            }
        }
    }


    fun validar():Boolean{
        var validar = true
        var nom  = findViewById(R.id.etxtcorreo) as EditText
        var contra = findViewById(R.id.etxtcontra) as EditText

        var nombres = nom.text.toString()
        var contrasenia = contra.text.toString()

        if(nombres.isEmpty() || !nombres.contains("@educantabria.es")){
            return  false
        }
        if(contrasenia.toString().isEmpty()){
            return  false
        }
        return validar
    }

    suspend fun getUsuarioActivo(email: String, password: String): Usuario_activo {
        var usuario_activo: Usuario_activo? = null
        CoroutineScope(Dispatchers.IO).launch {
            val apiService = retrofit.create(ApiService::class.java)
            val requestBody = UsuarioResponse.RequestBody(email, password)
            val call = apiService.getUsuario(requestBody).execute()
            if (call.isSuccessful) {
                usuario_activo = Usuario_activo(call.body()?.personalId, call.body()?.nombre, call.body()?.incidencias)
                Log.i("call", call.message())
                Log.i("usuario_activo", usuario_activo.toString())
            } else {
                print(call.errorBody().toString())
                print("No funciona")
            }
        }
        withContext(Dispatchers.IO) {
            while (usuario_activo == null) {
                delay(100) // Wait for 100ms before checking again
            }
        }
        return usuario_activo!!
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

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://10.0.2.2:8080/personal/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

