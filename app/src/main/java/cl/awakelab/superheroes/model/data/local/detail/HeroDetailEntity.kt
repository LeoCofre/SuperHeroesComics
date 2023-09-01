package cl.awakelab.superheroes.model.data.local.detail

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_heroe_details")
class HeroDetailEntity (
    @SerializedName("Año_creacion") val anioCreacion: Int,
    val id: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String

)
