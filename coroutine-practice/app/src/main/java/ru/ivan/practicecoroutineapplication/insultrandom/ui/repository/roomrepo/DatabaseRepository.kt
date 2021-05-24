package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.roomrepo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.room.Room
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

class DatabaseRepository(val context: Context) {

    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "database").build();

    fun getAll(): LiveData<List<InsultRoomModel>> {
        return database.insultDao().getAll().asLiveData()
    }

    suspend fun insert(insult: InsultRoomModel) {
        database.insultDao().insert(insult)
    }

    suspend fun getModel(number: String): InsultRoomModel {
        return database.insultDao().getById(number)
    }
}