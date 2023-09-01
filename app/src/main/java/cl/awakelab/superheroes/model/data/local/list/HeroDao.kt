package cl.awakelab.superheroes.model.data.local.list

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero( heroEntity: List<HeroEntity>)

    @Query("Select * from tabla_heroe order by id asc")
    fun getHeros(): LiveData<List<HeroEntity>>
}