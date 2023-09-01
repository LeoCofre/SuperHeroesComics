package cl.awakelab.superheroes.model.data.local.list

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.awakelab.superheroes.model.data.local.detail.HeroDetailEntity

@Dao
interface HeroDao {

    //Se insertan los datos a la lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero( heroEntity: List<HeroEntity>)

    @Query("Select * from tabla_heroe order by id asc")
    fun getHeros(): LiveData<List<HeroEntity>>

    //Se insertan datos al detalle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroDetail(heroDetailEntity: HeroDetailEntity)

    @Query("Select * from tabla_heroe_details where id = :id" )
    fun getHeroDetails(id: Int): LiveData<HeroDetailEntity>
}