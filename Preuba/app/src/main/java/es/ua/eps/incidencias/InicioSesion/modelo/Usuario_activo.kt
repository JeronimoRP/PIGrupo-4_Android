package es.ua.eps.incidencias.InicioSesion.modelo

import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.UsuarioResponse

class Usuario_activo : java.io.Serializable {
    var id : String? = "0"
    var nombre : String? = "Default"
    var incidenciaList: List<Incidencia>? = emptyList()


    constructor( personalId:String?, nombre:String?, incidencia:List<Incidencia>?){
        this.id = personalId
        this.nombre = nombre
        this.incidenciaList = incidencia
    }

    constructor()



}