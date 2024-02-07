package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ItemIncidenciasBinding

class IncidenciaViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val binding =ItemIncidenciasBinding.bind(view)

    //Creamos metodo para unir la informacion del di
    fun bind(incidencia:Incidencia){
        binding.txtAula.text = "Aula: ${incidencia.aula}  equipo:  ${incidencia.equioi}"
        binding.txtEtiqueta.text ="Etiqueta: ${incidencia.etiqueta}"
        binding.txtDescripcion.text = incidencia.descripcion
        binding.btnEstado.text = incidencia.estado
        var inic :String = incidencia.estado.toString()
        when(inic){
            "cerrada" ->  binding.btnEstado.setBackgroundColor(Color.parseColor("#FF3333"))

            "resuelta" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#66ff66"))

            "enviada a infotec","en proceso" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#E8B34B"))

            "asignada" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#FF944D"))

            "abierta" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#999999"))
        }


    }
}