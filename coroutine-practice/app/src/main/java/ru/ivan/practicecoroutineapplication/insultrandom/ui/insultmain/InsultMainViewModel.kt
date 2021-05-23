package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.API
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.APIRetrofitImpl
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.DatabaseRepository
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.RoomMapper

class InsultMainViewModel(private val app: Application) : AndroidViewModel(app) {

    private val api: API = APIRetrofitImpl()
    private var requestJob: Job? = null
    private var insertFavorite: Job? = null
    private val database: DatabaseRepository
    private val roomMapper: RoomMapper = RoomMapper()
    val insult: MutableLiveData<InsultPresentationModel> = MutableLiveData()
    val changeIcon = MutableLiveData<Boolean>()
    val changeFragment = MutableLiveData<Boolean>()

    init {
        database =  DatabaseRepository(getApplication())
        fetchInsult()
    }

    fun fetchInsult() {
        requestJob?.let {
            if (it.isActive) return
        }
        requestJob = viewModelScope.launch {
            api.getInsult()?.let {
                insult.value = it

                database.getModel(it.number)?.let {
                    changeIcon.value = true
                }
            }
        }
    }

    fun onFavoriteClick() {
        insertFavorite?.let {
            if (it.isActive) return
        }

        changeIcon.value = true

        insertFavorite = viewModelScope.launch {
            val lastValue = insult.value
            val resultSearch = database.getModel(lastValue?.number ?: "")

            if (resultSearch == null) {
                lastValue?.let {
                    database.insert(roomMapper.prepareForDatabase(it))
                }
            }
        }
    }
}