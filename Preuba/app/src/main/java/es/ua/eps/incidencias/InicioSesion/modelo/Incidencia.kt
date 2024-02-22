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
    public fun addComentario(comentario:String){
        this.comentarios?.add(comentario)
    }
}