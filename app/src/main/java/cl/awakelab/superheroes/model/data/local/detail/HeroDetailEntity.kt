package cl.awakelab.superheroes.model.data.local.detail

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_heroe_details")
class HeroDetailEntity (
    @SerializedName("Año_creacion") val anioCreacion: Int,
    @PrimaryKey val id: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String,
    val color: String,
    val traduccion: Boolean

)
