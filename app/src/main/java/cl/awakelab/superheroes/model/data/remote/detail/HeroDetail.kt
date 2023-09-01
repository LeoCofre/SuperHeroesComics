package cl.awakelab.superheroes.model.data.remote.detail

import com.google.gson.annotations.SerializedName


data class HeroDetail(
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val poder: String,
    @SerializedName("año_creacion")val anioCreacion: Int,
    val color: String,
    val traduccion: Boolean
)
