package com.garun.features_vm.LoadingScreenVM

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.garun.base.base.MviViewModel
import com.garun.data.repository.ProfileRepositoryImpl
import com.garun.data.repository.storage.Dependencies
import com.garun.features_vm.LoadingScreenVM.mvi.event.LoadingEvent
import com.garun.features_vm.LoadingScreenVM.mvi.intent.LoadingIntent
import com.garun.features_vm.LoadingScreenVM.mvi.state.LoadingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingScreenViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoadingScreenViewModel(context = context) as T
    }
}