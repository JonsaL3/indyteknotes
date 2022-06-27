package es.indytek.indyteknotes.data.sqlite

import android.annotation.SuppressLint
import android.content.Context
import es.indytek.indyteknotes.model.Imagen
import java.lang.Exception

class DBImagen (

    private val contexto: Context

) : IndytekNotesDatabaseHelper(contexto) {

    @SuppressLint("Recycle")
    fun saveImagen(imagen: Imagen) {

        try {

            this.writableDatabase.use { db ->

                val contentValues = imagen.getContentValues()
                val query = "SELECT * FROM ${Tablas.TablaImagen.TABLANOMBRE} WHERE ${Tablas.TablaImagen.ID} = ?"

                db.rawQuery(query, arrayOf(imagen.id.toString())).use { cursor ->
                    if (cursor.count > 0)
                        db.update(Tablas.TablaImagen.TABLANOMBRE, contentValues, "${Tablas.TablaImagen.ID} = ?", arrayOf(imagen.id.toString()))
                    else
                        db.insert(Tablas.TablaImagen.TABLANOMBRE, null, contentValues)
                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}