package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.retrofitrepo

import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel

interface API {

    suspend fun getInsult(): InsultPresentationModel?
}