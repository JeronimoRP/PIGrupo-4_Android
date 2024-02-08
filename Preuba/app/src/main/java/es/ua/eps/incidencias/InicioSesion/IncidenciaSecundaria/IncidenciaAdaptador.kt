package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.Incidencia
import es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria.IncidenciaViewHolder
import es.ua.eps.incidencias.R


class IncidenciaAdaptador  (val incidenciaList: List<Incidencia>,private val onClickListener:(Incidencia) ->Unit) :
    RecyclerView.Adapter<IncidenciaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciaViewHolder {
        //Nos infla la lista
        //Creamos un layout inflater
        val layoutInflater = LayoutInflater.from(parent.context)
        //Lo siguiente devolvermos un dico view holder y se le da el nombre del xml
        return IncidenciaViewHolder(layoutInflater.inflate(R.layout.item_incidencias ,parent, false))
    }

    override fun onBindViewHolder(holder: IncidenciaViewHolder, position: Int) {
        //Este metodo pinta
        val item = incidenciaList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return incidenciaList.size
    }
}
