package es.ua.eps.incidencias.InicioSesion.APIAccess.Response

import com.google.gson.annotations.SerializedName
import es.ua.eps.incidencias.InicioSesion.modelo.Incidencia
class UsuarioResponse{

    data class UsuarioDataResponse(
        @SerializedName("response") val response: String,
        @SerializedName("results") val superheroes: List<UsuarioItemResponse>
    )

    data class UsuarioItemResponse(
        @SerializedName("personalId") val personalId: String,
        @SerializedName("nombre") val  nombre : String,
        @SerializedName("incidencias") val incidencias: List<Incidencia>,

        )

    data class RequestBody(
        val educantabria: String,
        val password: String
    )
}