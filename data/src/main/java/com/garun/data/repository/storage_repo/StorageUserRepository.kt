package com.garun.data.repository.storage_repo

import com.garun.base.model.ProfileModel

interface StorageUserRepository {

    fun saveUser(user: ProfileModel)

    fun getUser() : ProfileModel

}