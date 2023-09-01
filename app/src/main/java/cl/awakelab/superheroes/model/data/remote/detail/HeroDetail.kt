package cl.awakelab.superheroes.model.data.remote.detail

import com.google.gson.annotations.SerializedName


data class HeroDetail(
    @SerializedName("año_creacion")val anioCreacion: Int,
    val id: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String,
    val color: String,
    val traduccion: Boolean
)
