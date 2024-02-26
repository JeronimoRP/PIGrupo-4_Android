package es.ua.eps.incidencias.InicioSesion.modelo

import java.io.Serializable

class Personal : Serializable {
    var id = 0

    var activo: Byte = 0

    var apellido1: String? = null

    var apellido2: String? = null

    var cp: String? = null

    var direccion: String? = null

    var dni: String? = null

    var localidad: String? = null

    var nombre: String? = null

    var tlf: String? = null

    var perfile: String? = null

    var departamento: String? = null



}