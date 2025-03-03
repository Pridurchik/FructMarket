package com.garun.features_vm.LoadingScreenVM.mvi.intent

import com.garun.base.base.MviIntent

sealed class LoadingIntent : MviIntent {

    data object UpdateUser: LoadingIntent()

}