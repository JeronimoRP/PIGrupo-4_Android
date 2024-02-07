package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

import java.io.Serializable

class Incidencia : Serializable {
    var aula:String ?= null
    var etiqueta:String ?= null
    var equioi :String ?= null
    var descripcion:String ?= null
    var estado :String ?=null

    constructor()

    constructor(nombre:String){
        this.aula = nombre
    }

    constructor(aula:String, equip:String, eti:String, descrip:String,estad:String){
        this.aula = aula
        this.equioi = equip
        this.etiqueta = eti
        this.descripcion = descrip
        this.estado = estad
    }
}