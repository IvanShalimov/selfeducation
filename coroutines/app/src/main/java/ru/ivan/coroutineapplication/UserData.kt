package ru.ivan.coroutineapplication

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * Пример того как создать класс, чтобы его экземпляры можно было помещать в контекст
 * Наследуем AbstractCoroutineContextElement(Название класса)
 * Добавляем ему companion object Key: CoroutineContext.Key<Название класса>
 * */
class UserData(
    val id: Long,
    val name: String,
    val age: Int
): AbstractCoroutineContextElement(UserData) {
    companion object Key: CoroutineContext.Key<UserData>
}