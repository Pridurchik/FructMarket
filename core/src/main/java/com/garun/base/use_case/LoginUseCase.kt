package com.garun.base.use_case

import com.garun.base.model.ProfileModel

fun loginUseCase(
    profileModel: ProfileModel,
    loginUserCallback: (user: ProfileModel) -> Unit
) {
    loginUserCallback.invoke(profileModel)
}