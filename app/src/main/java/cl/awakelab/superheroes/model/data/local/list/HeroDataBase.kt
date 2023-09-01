package cl.awakelab.superheroes.model.data.local.list

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HeroEntity :: class], version = 1)
abstract class HeroDataBase: RoomDatabase() {

    abstract fun getHeroDao(): HeroDao

    companion object{
        @Volatile
        private var INSTANCE: HeroDataBase? = null

        fun getDataBase(context: Context): HeroDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDataBase::class.java,
                    "heros_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}