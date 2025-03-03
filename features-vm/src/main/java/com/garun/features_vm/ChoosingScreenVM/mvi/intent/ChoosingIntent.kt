package com.garun.features_vm.ChoosingScreenVM.mvi.intent

import com.garun.base.base.MviIntent
import com.garun.features_vm.ChoosingScreenVM.model.User

sealed class ChoosingIntent : MviIntent {

    data object LoginButton : ChoosingIntent()

    data object AuthButton : ChoosingIntent()

}