package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository

import android.content.Context
import androidx.room.Room
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

class DatabaseRepository(val context: Context) {

    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "database").build();

    suspend fun getAll(): List<InsultRoomModel> {
        return database.insultDao().getAll()
    }

    suspend fun insert(insult: InsultRoomModel) {
        database.insultDao().insert(insult)
    }

    suspend fun getModel(number: String): InsultRoomModel {
        return database.insultDao().getById(number)
    }
}