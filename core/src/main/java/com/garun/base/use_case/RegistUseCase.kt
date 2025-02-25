package com.garun.base.use_case

import com.garun.base.model.ProfileModel

fun registUseCase(
    profileModel: ProfileModel,
    registUserCallback: (user: ProfileModel) -> Unit
) {
    registUserCallback.invoke(profileModel)
}