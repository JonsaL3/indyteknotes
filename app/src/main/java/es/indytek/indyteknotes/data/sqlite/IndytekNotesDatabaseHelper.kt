package es.indytek.indyteknotes.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class IndytekNotesDatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "indyteknotes.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.let {
            it.execSQL(Tablas.TablaImagen.CREATE_TABLA)
            it.execSQL(Tablas.TablaEstado.CREATE_TABLA)
            it.execSQL(Tablas.TablaUsuario.CREATE_TABLA)
            it.execSQL(Tablas.TablaTarea.CREATE_TABLA)
            it.execSQL(Tablas.TablaTareaImagen.CREATE_TABLA)
            it.execSQL(Tablas.TablaNota.CREATE_TABLA)
            it.execSQL(Tablas.TablaNotaImagen.CREATE_TABLA)
        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        p0?.let {
            it.execSQL(Tablas.TablaImagen.DROP_TABLA)
            it.execSQL(Tablas.TablaEstado.DROP_TABLA)
            it.execSQL(Tablas.TablaUsuario.DROP_TABLA)
            it.execSQL(Tablas.TablaTarea.DROP_TABLA)
            it.execSQL(Tablas.TablaTareaImagen.DROP_TABLA)
            it.execSQL(Tablas.TablaNota.DROP_TABLA)
            it.execSQL(Tablas.TablaNotaImagen.DROP_TABLA)
        }

        onCreate(p0)

    }

}