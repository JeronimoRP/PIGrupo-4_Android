package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import es.ua.eps.incidencias.InicioSesion.EditarIncidencias.EditarIncidencias
import es.ua.eps.incidencias.databinding.ActivityIncidenciaSecundariaBinding

class IncidenciaResuminda : AppCompatActivity() {
    lateinit var binding: ActivityIncidenciaSecundariaBinding
    private var incidenciasMutableList: MutableList<Incidencia> =
        IncidenciaProvider.incidenciaList.toMutableList()
    private lateinit var adapter: IncidenciaAdaptador

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

        initRecycleView()

    }

    private fun initRecycleView() {
        binding.rvIncidencias.adapter = IncidenciaAdaptador(
            incidenciaList = incidenciasMutableList,
            onClickListener = { incidencia -> onItemSelected(incidencia) },
            onClickEliminar = { position -> onDeletedItem(position) }

        )
    }

    fun onDeletedItem(position: Int) {
        mensajeEliminar(position)
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

}