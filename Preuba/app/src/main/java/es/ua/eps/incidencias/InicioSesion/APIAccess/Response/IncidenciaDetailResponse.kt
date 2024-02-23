package es.ua.eps.incidencias.InicioSesion.APIAccess.Response

import com.google.gson.annotations.SerializedName
data class IncidenciaDetailResponse (
    @SerializedName("name") val name: String
)
