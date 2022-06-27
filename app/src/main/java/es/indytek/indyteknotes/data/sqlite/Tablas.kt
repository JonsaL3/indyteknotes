package es.indytek.indyteknotes.data.sqlite

class Tablas {

    // Clase representativa de la tabla
    abstract class TablaImagen {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "IMAGEN"

            // Atributos de la tabla
            const val ID = "id"
            const val IMAGEN = "imagen"

            // Borrado tabla
            const val DROP_TABLA = "DROP TABLE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$IMAGEN VARCHAR " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaEstado {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "ESTADO"

            // Atributos de la tabla
            const val ID = "id"
            const val NOMBRE = "nombre"

            // Borrado tabla
            const val DROP_TABLA = "DROP TABLE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$NOMBRE VARCHAR " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaUsuario {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "USUARIO"

            // Atributos de la tabla
            const val ID = "id"
            const val CORREO = "correo"
            const val CONTRASENA = "contrasena"
            const val ID_FOTO_PERFIL = "id_foto_perfil"
            const val ID_FOTO_FONDO = "id_foto_fondo"

            // Borrado tabla
            const val DROP_TABLA = "DROP TABLE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$CORREO VARCHAR, " +
                    "$CONTRASENA VARCHAR, " +
                    "$ID_FOTO_PERFIL VARCHAR, " +
                    "$ID_FOTO_FONDO VARCHAR, " +
                    "FOREIGN KEY ($ID_FOTO_FONDO) REFERENCES ${TablaImagen.TABLANOMBRE}(${TablaImagen.ID}), " +
                    "FOREIGN KEY ($ID_FOTO_PERFIL) REFERENCES ${TablaImagen.TABLANOMBRE}(${TablaImagen.ID}) " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaTarea {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "TAREA"

            // Atributos de la tabla
            const val ID = "id"
            const val TITULO = "titulo"
            const val CONTENIDO = "contenido"
            const val FECHA_CREACION = "fecha_creacion"
            const val FECHA_LIMITE = "fecha_limite"
            const val ID_ESTADO = "id_estado"
            const val ID_USUARIO = "id_usuario"

            // Borrado tabla
            const val DROP_TABLA = "DROP TABLE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$TITULO VARCHAR, " +
                    "$CONTENIDO VARCHAR, " +
                    "$FECHA_CREACION DATETIME, " +
                    "$FECHA_LIMITE DATETIME, " +
                    "$ID_ESTADO INT, " +
                    "$ID_USUARIO INT, " +
                    "FOREIGN KEY ($ID_ESTADO) REFERENCES ${TablaEstado.TABLANOMBRE}(${TablaEstado.ID}), " +
                    "FOREIGN KEY ($ID_USUARIO) REFERENCES ${TablaUsuario.TABLANOMBRE}(${TablaUsuario.ID}) " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaTareaImagen {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "TAREA_IMAGEN"

            // Atributos de la tabla
            const val ID = "id"
            const val ID_IMAGEN = "id_imagen"
            const val ID_TAREA = "id_tarea"

            // Borrado tabla
            const val DROP_TABLA = "DROP DATABASE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$ID_IMAGEN INT NOT NULL, " +
                    "$ID_TAREA INT NOT NULL, " +
                    "FOREIGN KEY ($ID_IMAGEN) REFERENCES ${TablaImagen.TABLANOMBRE}(${TablaImagen.ID}), " +
                    "FOREIGN KEY ($ID_TAREA) REFERENCES ${TablaTarea.TABLANOMBRE}(${TablaTarea.ID}) " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaNota {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "NOTA"

            // Atributos de la tabla
            const val ID = "id"
            const val TITULO = "titulo"
            const val CONTENIDO = "contenido"
            const val FECHA_CREACION = "fecha_creacion"
            const val ID_USUARIO = "id_usuario"

            // Borrado tabla
            const val DROP_TABLA = "DROP TABLE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$TITULO VARCHAR, " +
                    "$CONTENIDO VARCHAR, " +
                    "$FECHA_CREACION DATETIME, " +
                    "$ID_USUARIO INT, " +
                    "FOREIGN KEY ($ID_USUARIO) REFERENCES ${TablaUsuario.TABLANOMBRE}(${TablaUsuario.ID}) " +
                    ")"

        }
    }

    // Clase representativa de la tabla
    abstract class TablaNotaImagen {
        companion object {

            // Nombre de la tabla
            const val TABLANOMBRE = "NOTA_IMAGEN"

            // Atributos de la tabla
            const val ID = "id"
            const val ID_IMAGEN = "id_imagen"
            const val ID_NOTA = "id_nota"

            // Borrado tabla
            const val DROP_TABLA = "DROP DATABASE IF EXISTS $TABLANOMBRE"

            // Creación de la tabla
            const val CREATE_TABLA = "CREATE TABLE IF NOT EXISTS $TABLANOMBRE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$ID_IMAGEN INT NOT NULL, " +
                    "$ID_NOTA INT NOT NULL, " +
                    "FOREIGN KEY ($ID_IMAGEN) REFERENCES ${TablaImagen.TABLANOMBRE}(${TablaImagen.ID}), " +
                    "FOREIGN KEY ($ID_NOTA) REFERENCES ${TablaNota.TABLANOMBRE}(${TablaNota.ID}) " +
                    ")"

        }
    }

}