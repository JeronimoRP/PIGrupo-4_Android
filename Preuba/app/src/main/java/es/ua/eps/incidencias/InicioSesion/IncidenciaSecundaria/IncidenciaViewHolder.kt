package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.graphics.Color
import android.view.View
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.incidencias.InicioSesion.modelo.Incidencia
import es.ua.eps.incidencias.databinding.ItemIncidenciasBinding

class IncidenciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemIncidenciasBinding.bind(view)

    //Creamos metodo para unir la informacion del di
    fun bind(
        incidencia: Incidencia,
        onClickListener: (Incidencia) -> Unit,
        onClickEliminar: (Int) -> Unit
    ) {
        binding.txtAula.text = "Aula: ${incidencia.tipo} "
        binding.txtEtiqueta.text = "Etiqueta: ${incidencia.tipo}"
        binding.txtDescripcion.text = "Descripcion: ${incidencia.descripcion}"
        binding.btnEstado.text = incidencia.estado
        binding.imgbotoneditar.setOnClickListener { onClickListener(incidencia) }
        binding.imgbotonbasura.setOnClickListener{onClickEliminar(adapterPosition)}

    var inic: String = incidencia.estado.toString()
    when(inic)
    {
        "cerrada" -> {
        binding.btnEstado.setBackgroundColor(Color.parseColor("#FF3333"))
        binding.imgbotoneditar.isInvisible = true
        binding.imgbotonbasura.isInvisible = true
    }
        "resuelta" -> {
        binding.btnEstado.setBackgroundColor(Color.parseColor("#66ff66"))
    }
        "enviada a infotec", "en proceso" -> {
        binding.btnEstado.setBackgroundColor(Color.parseColor("#E8B34B"))
    }

        "asignada" -> {
        binding.btnEstado.setBackgroundColor(Color.parseColor("#FF944D"))
    }

        "abierta" -> binding.btnEstado.setBackgroundColor(Color.parseColor("#999999"))
    }

}
}