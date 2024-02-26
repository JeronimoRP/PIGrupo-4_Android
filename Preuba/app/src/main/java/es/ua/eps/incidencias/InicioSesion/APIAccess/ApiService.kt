package es.ua.eps.incidencias.InicioSesion.APIAccess

import retrofit2.http.Path
import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.IncidenciaDataResponse
import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.IncidenciaDetailResponse
import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.UsuarioResponse.RequestBody
import es.ua.eps.incidencias.InicioSesion.APIAccess.Response.UsuarioResponse.UsuarioItemResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login") //TODO: CAMBIAR ENDPOINT A FINAL
    fun getUsuario(@Body requestBody: RequestBody): Call<UsuarioItemResponse>

}