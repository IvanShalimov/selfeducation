package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.roomrepo

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models.InsultRoomModel

@Database(entities = [InsultRoomModel::class] , version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun insultDao(): InsultsDao
}