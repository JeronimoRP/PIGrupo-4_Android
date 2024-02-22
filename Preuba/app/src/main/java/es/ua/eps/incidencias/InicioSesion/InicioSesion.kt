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
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ActivityIniciosesionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InicioSesion : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    var nombre :String ?=""
    var id :String ?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        binding.btnInicioSesion.setOnClickListener(){
            var vali = validar()
            if (vali == true) {
                val intent2 = Intent(this, IncidenciaResuminda::class.java)
                intent2.putExtra("nombre",nombre)
                startActivity(intent2)
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
        CoroutineScope(Dispatchers.IO).launch {
            val apiService = retrofit.create(ApiService::class.java)

            val requestBody = UsuarioResponse.RequestBody("edu@educantabria.es", "1234")
            val call = apiService.getUsuario(requestBody)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        response.body()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i("Credenciales","No se puede conectar a la api")
                }
            })

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

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<ResponseBody>) {

}
