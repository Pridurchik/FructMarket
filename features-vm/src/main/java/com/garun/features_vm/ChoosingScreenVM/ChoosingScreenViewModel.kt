package com.garun.features_vm.ChoosingScreenVM

import androidx.lifecycle.ViewModel
import com.garun.base.base.MviViewModel
import com.garun.features_vm.ChoosingScreenVM.mvi.event.ChoosingEvent
import com.garun.features_vm.ChoosingScreenVM.mvi.intent.ChoosingIntent
import com.garun.features_vm.ChoosingScreenVM.mvi.state.ChoosingScreenState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class ChoosingScreenViewModel(

) : MviViewModel<ChoosingIntent, ChoosingScreenState, ChoosingEvent>, ViewModel() {

    private val _viewState: StateFlow<ChoosingScreenState> =
        MutableStateFlow(value = ChoosingScreenState())
    override val viewState: StateFlow<ChoosingScreenState>
        get() = _viewState

    private val _event = MutableSharedFlow<ChoosingEvent>()
    override val singleEvent: SharedFlow<ChoosingEvent>
        get() = _event


    override fun processIntent(intent: ChoosingIntent) = Unit

}