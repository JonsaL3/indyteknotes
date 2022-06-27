package es.indytek.indyteknotes.data.sqlite

import android.annotation.SuppressLint
import android.content.Context
import es.indytek.indyteknotes.model.Imagen
import es.indytek.indyteknotes.model.Nota
import java.lang.Exception

class DBNota (

    private val contexto: Context

) : IndytekNotesDatabaseHelper(contexto) {

    fun findAllNotasByIdUsuario(idUsuario: Int): ArrayList<Nota>? {

        var notas: ArrayList<Nota>? = null

        try {

            this.readableDatabase.use { db ->

                val query = "SELECT * FROM ${Tablas.TablaNota.TABLANOMBRE} WHERE ${Tablas.TablaNota.ID_USUARIO} = ?"
                val cursor = db.rawQuery(query, arrayOf(idUsuario.toString()))

                if (cursor.moveToFirst()) {
                    notas = ArrayList()
                    do {
                        notas!!.add(Nota.getByCursor(cursor))
                    } while (cursor.moveToNext())
                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return notas
    }

}