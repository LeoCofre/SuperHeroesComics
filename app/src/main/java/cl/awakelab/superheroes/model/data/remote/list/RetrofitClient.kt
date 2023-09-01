package cl.awakelab.superheroes.model.data.remote.list

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = " https://y-mariocanedo.vercel.app/"

class RetrofitClient {
    companion object {

        fun retrofitInstance(): HerosApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(HerosApi::class.java)
        }
    }
}