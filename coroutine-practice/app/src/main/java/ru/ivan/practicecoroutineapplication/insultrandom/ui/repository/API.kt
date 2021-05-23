package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel

interface API {

    suspend fun getInsult(): InsultPresentationModel?
}