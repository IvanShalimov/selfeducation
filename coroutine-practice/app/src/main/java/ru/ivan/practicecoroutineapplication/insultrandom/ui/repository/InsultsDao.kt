package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

@Dao
interface InsultsDao {

    @Query("SELECT * FROM insult")
    suspend fun getAll(): List<InsultRoomModel>

    @Query("SELECT * FROM insult WHERE number = :id")
    suspend fun getById(id: String): InsultRoomModel

    @Insert
    suspend fun insert(insult: InsultRoomModel)
}