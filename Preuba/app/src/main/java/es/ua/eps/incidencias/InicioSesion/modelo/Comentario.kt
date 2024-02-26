package es.ua.eps.incidencias.InicioSesion.modelo

import java.io.Serializable

class Comentario  : Serializable {
    var id : String ?= null
    var texto : String ?= null
    var fechahora : String ?= null
    var incidencia_num : String ?= null
    var personal_id : String ?= null
    var adjunto_url : String ?= null

    constructor(
        id: String?,
        texto: String?,
        fechahora: String?,
        incidencia_num: String?,
        personal_id: String?,
        adjunto_url: String?
    ) {
        this.id = id
        this.texto = texto
        this.fechahora = fechahora
        this.incidencia_num = incidencia_num
        this.personal_id = personal_id
        this.adjunto_url = adjunto_url
    }
}