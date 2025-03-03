package com.garun.features_vm.LoadingScreenVM

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garun.base.base.MviViewModel
import com.garun.base.model.ProfileModel
import com.garun.data.model.ProfileEntity
import com.garun.data.repository.ProfileRepositoryImpl
import com.garun.data.repository.UserRepositoryImpl
import com.garun.data.repository.storage.AppDatabase
import com.garun.data.repository.storage.Dependencies
import com.garun.data.repository.storage.StorageUserRepositoryImpl
import com.garun.features_vm.LoadingScreenVM.mvi.event.LoadingEvent
import com.garun.features_vm.LoadingScreenVM.mvi.intent.LoadingIntent
import com.garun.features_vm.LoadingScreenVM.mvi.state.LoadingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

class LoadingScreenViewModel(
    context: Context
): MviViewModel<LoadingIntent, LoadingState, LoadingEvent>, ViewModel() {

    private val _state = MutableStateFlow(LoadingState(isLoading = false))
    override val viewState: StateFlow<LoadingState>
        get() = _state.asStateFlow()

    private val _event = MutableSharedFlow<LoadingEvent>()
    override val singleEvent: SharedFlow<LoadingEvent>
        get() = _event.asSharedFlow()


    override fun processIntent(intent: LoadingIntent) {

        when(intent) {
            is LoadingIntent.UpdateUser -> {
                updateState()
            }
        }

    }

    init {
        Dependencies.init(context = context)

        TestAddUser(Dependencies.appDatabase)
    }


    private fun TestAddUser(
        db: AppDatabase
    ) {

        viewModelScope.launch {

            UserRepositoryImpl(
                storageUser = StorageUserRepositoryImpl(
                    appDatabase = db
                )
            ).loginUser(
                model = ProfileModel(
                    email = "magomedovgarun02@gmail.com",
                    name = "Garun",
                    password = "123123"
                )
            )
        }

        updateState()
    }


    /*
        Получаем информацию авторизован ли уже юзер в системе
    */
    private fun updateState() {
        val db = {
            Dependencies.appDatabase
        }

        viewModelScope.launch {
            val profile_repo = ProfileRepositoryImpl(
                appDatabase = db.invoke()
            ).isEnter()

            // Иммитация долгой загрузки
            delay(3000)

            _state.emit(
                LoadingState(
                    isLoading = profile_repo
                )
            )

            _event.emit(
                value = LoadingEvent.NavigateToStartScreen
            )

        }

    }


}