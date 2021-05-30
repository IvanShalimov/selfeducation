package ru.ivan.coroutineflowapplication.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class InsultAPIImpl {
    private val service: InsultAPI
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://evilinsult.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
    private val defaultInsult: InsultAPIModel = InsultAPIModel(insult = "You're breathtaking")

    init {
        service = retrofit.create(InsultAPI::class.java)
    }

    fun beInsulted(): Flow<InsultAPIModel> {
        return ::getInsult.asFlow()
    }

    private suspend fun getInsult(): InsultAPIModel {
        return withContext(Dispatchers.IO) {
            val response = service.getRandomInsult()
            if (response.isSuccessful) {
                response.body()?.let { it } ?: defaultInsult
            } else {
                defaultInsult
            }
        }
    }
}