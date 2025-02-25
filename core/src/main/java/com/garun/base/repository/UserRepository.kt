package com.garun.base.repository

import com.garun.base.model.ProfileModel

interface UserRepository {

     fun loginUser(model: ProfileModel)
     fun registUser(model: ProfileModel)

}