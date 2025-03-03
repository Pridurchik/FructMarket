package com.garun.features_vm.ChoosingScreenVM.mvi.event

import com.garun.base.base.MviSingleEvent

sealed class ChoosingEvent: MviSingleEvent {

    data object NavigateToLogin : ChoosingEvent()

    data object NavigateToRegist : ChoosingEvent()

    data object OpenGoogleLogin: ChoosingEvent()

    data object OpenFacebookLogin: ChoosingEvent()


}