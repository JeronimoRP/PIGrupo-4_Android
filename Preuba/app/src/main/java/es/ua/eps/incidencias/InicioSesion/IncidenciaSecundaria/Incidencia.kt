package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import java.io.Serializable

class Incidencia : Serializable {
    var aula:String ?= null
    var etiqueta:String ?= null
    var equipo :String ?= null
    var descripcion:String ?= null
    var estado :String ?=null
    var comentarios : MutableList<String> ?=null

    constructor()

    constructor(nombre:String){
        this.aula = nombre
    }

    constructor(aula:String, equip:String, eti:String, descrip:String,estad:String){
        this.aula = aula
        this.equipo = equip
        this.etiqueta = eti
        this.descripcion = descrip
        this.estado = estad
    }
    public fun addComentario(comentario:String){
        this.comentarios?.add(comentario)
    }
}