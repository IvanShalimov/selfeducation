package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

class RoomMapper {

    fun prepareForDatabase(insertModel: InsultPresentationModel) =
        InsultRoomModel(
            number = insertModel.number,
            insult = insertModel.insult,
            createdBy = insertModel.createdBy,
            created = insertModel.created
        )


    fun prepareRoomModelList(rawList: List<InsultRoomModel>): List<InsultPresentationModel> {
        return rawList.map { mapFromDatabase(it) }
    }


    private fun mapFromDatabase(room: InsultRoomModel): InsultPresentationModel {
        return InsultPresentationModel(
            number = room.number,
            insult = room.insult,
            created = room.created,
            createdBy = room.createdBy ?: ""
        )
    }
}