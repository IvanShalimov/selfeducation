package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

class RoomMapper {

    fun prepareForDatabase(insertModel: InsultPresentationModel) =
        InsultRoomModel(number = insertModel.number,
        insult = insertModel.insult,
        createdBy = insertModel.createdBy,
        created = insertModel.created)
    //    fun mapFromDatabase(insults: List< InsultRoomModel>) = InsultRoomModel()
}