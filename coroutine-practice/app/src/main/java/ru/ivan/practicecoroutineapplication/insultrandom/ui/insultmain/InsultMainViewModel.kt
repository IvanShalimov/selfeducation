package ru.ivan.practicecoroutineapplication.insultrandom.ui.insultmain

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import ru.ivan.practicecoroutineapplication.insultrandom.ui.models.InsultPresentationModel
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.retrofitrepo.API
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.retrofitrepo.APIRetrofitImpl
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.roomrepo.DatabaseRepository
import ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.roomrepo.RoomMapper


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
            //fetchInsultAlt()
        request()
    }

    fun fetchInsult() {
        requestJob?.let {
            if (it.isActive) return
        }
        requestJob = viewModelScope.launch {
            api.getInsult()?.let {
                insult.value = it

                database.getModel(it.number).let {
                    changeIcon.value = true
                }
            }
        }
    }

    /**Using kotlin runCatching */
    fun fetchInsultAlt(){
        val Response:Response

        requestJob?.let {
            if (it.isActive) return
        }

        requestJob = viewModelScope.launch {
            kotlin.runCatching {
                api.getInsult()
            }.onSuccess {
                insult.value = it

                database.getModel(it?.number?: "").let {
                    changeIcon.value = true
                }
            }.onFailure {
                Log.d("Ivan","${it.message}")
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

    fun request() {
        viewModelScope.launch {
            val result = okhttpReqesut()
            Log.d("Ivan","$result")
        }
    }

    suspend fun okhttpReqesut(): String{
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder().addHeader("Content-Type","application/json")
                .url("https://evilinsult.com/generate_insult.php?lang=en&type=json")
                .build()

            val response = client.newCall(request).execute()
            response.body()?.string() ?: "{loh}"
        }
    }

    fun getFavoritesList(): LiveData<List<InsultPresentationModel>> {
        val favorites = database.getAll()
        return Transformations.map(favorites) {
            roomMapper.prepareRoomModelList(it)
        }
    }
}