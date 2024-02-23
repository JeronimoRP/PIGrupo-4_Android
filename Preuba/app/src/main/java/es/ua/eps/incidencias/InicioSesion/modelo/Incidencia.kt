package es.ua.eps.incidencias.InicioSesion.modelo

import java.io.Serializable

class Incidencia : Serializable {
    var num : String ?= null
    var tipo : String ?= null
    var subtipo_id : String ?= null
    var fecha_creacion : String ?= null
    var fecha_cierre : String ?= null
    var descripcion : String ?= null
    var estado : String ?= null
    var adjunto_url : String ?= null
    var creador_id : String ?= null
    var responsable_id : String ?= null
    var equipo_id : Equipo ?= null
    var tiempo_dec : String ?= null
    var comentarios : MutableList<String> ?=null


    constructor()

    constructor(nombre:String){

    }

    constructor(aula:String, equip:String, eti:String, descrip:String,estad:String){
        this.descripcion = descrip
        this.estado = estad
    }

    constructor(
        num: String?,
        tipo: String?,
        subtipo_id: String?,
        fecha_creacion: String?,
        fecha_cierre: String?,
        descripcion: String?,
        estado: String?,
        adjunto_url: String?,
        creador_id: String?,
        responsable_id: String?,
        equipo_id: Equipo?,
        tiempo_dec: String?,
        comentarios: MutableList<String>?
    ) {
        this.num = num
        this.tipo = tipo
        this.subtipo_id = subtipo_id
        this.fecha_creacion = fecha_creacion
        this.fecha_cierre = fecha_cierre
        this.descripcion = descripcion
        this.estado = estado
        this.adjunto_url = adjunto_url
        this.creador_id = creador_id
        this.responsable_id = responsable_id
        this.equipo_id = equipo_id
        this.tiempo_dec = tiempo_dec
        this.comentarios = comentarios
    }


    public fun addComentario(comentario:String){
        this.comentarios?.add(comentario)
    }
}