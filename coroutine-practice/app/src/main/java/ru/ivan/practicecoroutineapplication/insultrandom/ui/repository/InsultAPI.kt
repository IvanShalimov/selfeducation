package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultAPIModel

interface InsultAPI {

    @Headers("Content-Type: application/json")
    @GET("generate_insult.php")
    suspend fun getRandomInsult(
        @Query("lang") lang: String = "ru",
        @Query("type") type: String = "json"
    ): Response<InsultAPIModel>
}