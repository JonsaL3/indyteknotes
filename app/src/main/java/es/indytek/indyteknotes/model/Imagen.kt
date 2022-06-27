package es.indytek.indyteknotes.model

import android.content.ContentValues
import com.google.gson.annotations.SerializedName
import es.indytek.indyteknotes.data.sqlite.Tablas
import java.io.Serializable

data class Imagen(

    @SerializedName(Tablas.TablaImagen.ID)
    var id: Int,
    @SerializedName(Tablas.TablaImagen.IMAGEN)
    var imagen: String

) : Serializable {

    fun getContentValues(): ContentValues = ContentValues().apply {
        put(Tablas.TablaImagen.ID, id)
        put(Tablas.TablaImagen.IMAGEN, imagen)
    }

}