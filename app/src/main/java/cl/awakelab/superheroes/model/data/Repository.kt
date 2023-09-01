package cl.awakelab.superheroes.model.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.superheroes.model.data.local.detail.HeroDetailEntity
import cl.awakelab.superheroes.model.data.local.list.HeroDao
import cl.awakelab.superheroes.model.data.local.list.HeroEntity
import cl.awakelab.superheroes.model.data.remote.list.HeroApi
import cl.awakelab.superheroes.model.data.remote.list.transformToDetailEntity
import cl.awakelab.superheroes.model.data.remote.list.transformToEntity

class Repository(private val heroApi: HeroApi, private val heroDao: HeroDao) {

    fun getHeroEntity(): LiveData<List<HeroEntity>> = heroDao.getHeros()

    fun getHeroDetailEntity(id: Long): LiveData<HeroDetailEntity> = heroDao.getHeroDetails(id)

    suspend fun getHeros() {
        try {
            val response = heroApi.getDataHeros()
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let {
                    val heroEntity = it.map { it.transformToEntity() }
                    heroDao.insertHero(heroEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("Repositorio", "En el Repositorio")
        }
    }

    suspend fun getHeroDetails(id: Long) {
        try {
            val response = heroApi.getDataHerosDetail(id)
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let {
                    val heroDetailEntity = it.transformToDetailEntity()
                    heroDao.insertHeroDetail(heroDetailEntity)
                }

            }
        } catch (exception: Exception) {
            Log.e("RepoDetail", "En el RepoDetail")
        }
    }
}