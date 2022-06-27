package es.indytek.indyteknotes.data.repository

import android.content.Context
import es.indytek.indyteknotes.data.sqlite.DBNota
import es.indytek.indyteknotes.model.Nota

// Aqui me abstraigo de donde vienen los datos, me da lo mismo
object NotaRepository {

    fun getNotasByIdUsuario(idUsuario: Int, contexto: Context): ArrayList<Nota>? {
        return DBNota(contexto).findAllNotasByIdUsuario(idUsuario)
    }

}