package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.graphics.Color
import android.view.View
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.incidencias.R
import es.ua.eps.incidencias.databinding.ItemIncidenciasBinding

class IncidenciaViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val binding =ItemIncidenciasBinding.bind(view)

    //Creamos metodo para unir la informacion del di
    fun bind(incidencia:Incidencia, onClickListener:(Incidencia) -> Unit){
        binding.txtAula.text = "Aula: ${incidencia.aula}  equipo:  ${incidencia.equioi}"
        binding.txtEtiqueta.text ="Etiqueta: ${incidencia.etiqueta}"
        binding.txtDescripcion.text = "Descripcion: ${incidencia.descripcion}"
        binding.btnEstado.text = incidencia.estado
        binding.imgbotoneditar.setOnClickListener{onClickListener(incidencia)}
        var inic :String = incidencia.estado.toString()
        when(inic){
            "cerrada" -> {
                binding.btnEstado.setBackgroundColor(Color.parseColor("#FF3333"))
                binding.imgbotoneditar.isInvisible = true

            }
            "resuelta" -> {
                binding.btnEstado.setBackgroundColor(Color.parseColor("#66ff66"))
                binding.imgbotoneditar.isInvisible = true
            }
            "enviada a infotec","en proceso" -> {
                binding.btnEstado.setBackgroundColor(Color.parseColor("#E8B34B"))
                binding.imgbotoneditar.isInvisible = true
            }

            "asignada" -> {
                binding.btnEstado.setBackgroundColor(Color.parseColor("#FF944D"))
                binding.imgbotoneditar.isInvisible = true
            }

            "abierta" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#999999"))
        }

    }
}