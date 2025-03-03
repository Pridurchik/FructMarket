package com.garun.features_vm.LoadingScreenVM.mvi.event

import com.garun.base.base.MviSingleEvent
import com.garun.features_vm.LoadingScreenVM.mvi.state.LoadingState

sealed class LoadingEvent : MviSingleEvent {

    data object NavigateToStartScreen : LoadingEvent()

    data object NavigateToMainScreen : LoadingEvent()

}