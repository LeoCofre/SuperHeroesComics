package cl.awakelab.superheroes.model.data.remote.list

import retrofit2.Response
import retrofit2.http.GET

interface HerosApi {
    @GET("superheroes/")
    suspend fun getAllHeros(): Response<List<Heros>>
}