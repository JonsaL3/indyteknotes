package es.indytek.indyteknotes.model

import android.database.Cursor
import com.google.gson.annotations.SerializedName
import es.indytek.indyteknotes.data.sqlite.Tablas
import java.io.Serializable
import java.time.LocalDateTime

data class Nota(

    @SerializedName("id")
    var id: Int,
    @SerializedName("titulo")
    var titulo: String,
    @SerializedName("contenido")
    var contenido: String,
    @SerializedName("fecha_creacion")
    var fechaCreacion: LocalDateTime,
    @SerializedName("id_usuario")
    var idUsuario: Int

) : Serializable {

    companion object {

        fun getByCursor(cursor: Cursor): Nota {
            val id = cursor.getInt(cursor.getColumnIndex(Tablas.TablaNota.ID))
            val titulo = cursor.getString(cursor.getColumnIndex(Tablas.TablaNota.TITULO))
            val contenido = cursor.getString(cursor.getColumnIndex(Tablas.TablaNota.CONTENIDO))
            val fechaCreacion = cursor.getString(cursor.getColumnIndex(Tablas.TablaNota.FECHA_CREACION))
            val idUsuario = cursor.getInt(cursor.getColumnIndex(Tablas.TablaNota.ID_USUARIO))
            return Nota(id, titulo, contenido, LocalDateTime.parse(fechaCreacion), idUsuario)
        }

    }

}