package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.roomrepo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

@Dao
interface InsultsDao {

    @Query("SELECT * FROM insult")
    fun getAll(): Flow<List<InsultRoomModel>>

    @Query("SELECT * FROM insult WHERE number = :id")
    suspend fun getById(id: String): InsultRoomModel

    @Insert
    suspend fun insert(insult: InsultRoomModel)
}