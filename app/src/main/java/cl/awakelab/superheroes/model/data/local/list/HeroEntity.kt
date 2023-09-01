package cl.awakelab.superheroes.model.data.local.list

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_heroe")
class HeroEntity (
    @SerializedName("Año_creacion") val anioCreacion: Int,
    val id: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String

)
