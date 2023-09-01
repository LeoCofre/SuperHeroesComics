package cl.awakelab.superheroes.model.data.remote.list

import com.google.gson.annotations.SerializedName

data class Heros(
    @SerializedName("Año_creacion") val anioCreacion: Int,
    val id: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String
)