package es.ua.eps.incidencias.InicioSesion.APIAccess.Response

import com.google.gson.annotations.SerializedName

data class IncidenciaDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<IncidenciaItemResponse>
)

data class IncidenciaItemResponse(
    @SerializedName("Aula") val aula: String,
    @SerializedName("Etiqueta") val etiqueta: String,
    @SerializedName("Equipo") val equipo: String,
    @SerializedName("Descripcion") val descripcion: String,
    @SerializedName("Estado") val estado: String,

)