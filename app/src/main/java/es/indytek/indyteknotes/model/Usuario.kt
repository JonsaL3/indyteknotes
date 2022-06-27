package es.indytek.indyteknotes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(

    @SerializedName("id")
    var id: Int,
    @SerializedName("correo")
    var correo: String,
    @SerializedName("contrasena")
    var contrasena: String,
    @SerializedName("id_foto_perfil")
    var idFotoPerfil: Int,
    @SerializedName("id_foto_fondo")
    var idFotoFondo: Int

) : Serializable {

}