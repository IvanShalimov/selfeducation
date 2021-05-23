package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultAPIModel

class RetrofitResponseMapper {

    fun map(rawResponse: InsultAPIModel) = InsultPresentationModel(
        number = rawResponse.number,
        insult = rawResponse.insult,
        created = rawResponse.created,
        createdBy = rawResponse.createdBy ?: ""
    )
}