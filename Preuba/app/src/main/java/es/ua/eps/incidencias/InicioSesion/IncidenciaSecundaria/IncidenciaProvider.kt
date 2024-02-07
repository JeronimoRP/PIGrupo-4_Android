package es.ua.eps.incidencias.InicioSesion.IncidenciaSecundaria

object IncidenciaProvider {
    val incidenciaList: MutableList<Incidencia> = mutableListOf<Incidencia>(
        Incidencia(
            "IFO02",
            "07",
            "099923",
            "El ordenador no enciende hace el ruido de funcionar se enciende y se apaga del tiron",
            "cerrada"
        ),
        Incidencia(
            "IFO12",
            "10",
            "045763",
            "Cambiar pantalla",
            "enviada a infotec"
        ),
        Incidencia(
            "IFO02",
            "02",
            "071045",
            "nO FURULA",
            "abierta"
        ),
        Incidencia(
            "IFO02",
            "02",
            "097345",
            "No va el teclado",
            "resuelta"
        ),
        Incidencia(
            "IFO02",
            "02",
            "075255",
            "nO FURULA",
            "asignada"
        ),
        Incidencia(
            "ISO01",
            "10",
            "076645",
            "No va el espacio",
            "en proceso"
        ),
    )
}
