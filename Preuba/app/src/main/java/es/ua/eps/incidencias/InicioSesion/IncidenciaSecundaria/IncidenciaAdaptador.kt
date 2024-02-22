package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.incidencias.InicioSesion.modelo.Incidencia
import es.ua.eps.incidencias.R

class IncidenciaAdaptador  (
    val incidenciaList: List<Incidencia>,
    private val onClickListener:(Incidencia) ->Unit,
    private val onClickEliminar:(Int) ->Unit ): RecyclerView.Adapter<IncidenciaViewHolder>(){
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
        holder.bind(item, onClickListener,onClickEliminar)
    }

    override fun getItemCount(): Int {
        return incidenciaList.size
    }
}
