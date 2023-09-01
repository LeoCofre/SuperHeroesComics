package cl.awakelab.superheroes.model.data.remote.list

import cl.awakelab.superheroes.model.data.remote.detail.HeroDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {
    @GET("superheroes/")
    suspend fun getDataHeros(): Response<List<Hero>>

    @GET("{ID}")
    suspend fun getDataHerosDetail(@Path("id") id: Long): Response<HeroDetail>
}