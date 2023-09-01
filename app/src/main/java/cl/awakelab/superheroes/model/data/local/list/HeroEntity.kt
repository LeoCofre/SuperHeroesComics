package cl.awakelab.superheroes.model.data.local.list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_heroe")
data class HeroEntity(
    @PrimaryKey val id: Int,
    val anioCreacion: Int,
    val imagenLink: String,
    val nombre: String,
    val origen: String,
    val poder: String

)
