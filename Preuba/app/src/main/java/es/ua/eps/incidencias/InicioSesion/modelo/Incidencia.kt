package es.ua.eps.incidencias.InicioSesion.modelo

import java.io.Serializable

class Incidencia : Serializable {
    var id: Int? = null

    var num = 0

    var adjuntoUrl: String? = null

    var descripcion: String? = null

    var estado: String? = null

    var fechaCierre: String? = null

    var fechaCreacion: String? = null

    var tipo: String? = null

    var comentarios: MutableList<Comentario>? = null

    var equipo: String? = null

    var incidenciasSubtipo: Tipo? = null

    var profesorIncidencia: Personal? = null

    var profesorAdministrador: Personal? = null


    constructor()
    constructor(
        id: Int?,
        num: Int,
        adjuntoUrl: String?,
        descripcion: String?,
        estado: String?,
        fechaCierre: String?,
        fechaCreacion: String?,
        tipo: String?,
        comentarios: MutableList<Comentario>?,
        equipo: String?,
        incidenciasSubtipo: Tipo?,
        profesorIncidencia: Personal?,
        profesorAdministrador: Personal?
    ) {
        this.id = id
        this.num = num
        this.adjuntoUrl = adjuntoUrl
        this.descripcion = descripcion
        this.estado = estado
        this.fechaCierre = fechaCierre
        this.fechaCreacion = fechaCreacion
        this.tipo = tipo
        this.comentarios = comentarios
        this.equipo = equipo
        this.incidenciasSubtipo = incidenciasSubtipo
        this.profesorIncidencia = profesorIncidencia
        this.profesorAdministrador = profesorAdministrador
    }


    public fun addComentario(comentario:Comentario){
        this.comentarios?.add(comentario)
    }
}