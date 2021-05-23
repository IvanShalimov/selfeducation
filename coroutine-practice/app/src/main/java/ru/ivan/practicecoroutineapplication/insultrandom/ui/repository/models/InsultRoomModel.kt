package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insult")
class InsultRoomModel(
    @PrimaryKey val number: String,
    val insult: String,
    val created: String,
    val createdBy: String?
)