package com.garun.features_vm.ChoosingScreenVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChoosingScreenViewModelFactory(

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChoosingScreenViewModel() as T
    }
}