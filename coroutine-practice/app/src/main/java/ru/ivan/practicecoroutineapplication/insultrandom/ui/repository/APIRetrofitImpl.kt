package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel


class APIRetrofitImpl : API {

    private val service: InsultAPI
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://evilinsult.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
    private val mapper: RetrofitResponseMapper = RetrofitResponseMapper()

    init {
        service = retrofit.create(InsultAPI::class.java)
    }

    override suspend fun getInsult(): InsultPresentationModel? {
        val response = try {
           service.getRandomInsult()
        } catch (e:Exception) {
            return null
        }

        return if(response.isSuccessful) {
            response.body()?.let {
                mapper.map(it)
            }
        } else {
            null
        }
    }
}