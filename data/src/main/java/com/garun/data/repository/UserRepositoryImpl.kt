package com.garun.data.repository

import com.garun.base.model.ProfileModel
import com.garun.base.repository.UserRepository
import com.garun.data.repository.storage_repo.StorageUserRepository

class UserRepositoryImpl(
    private val storageUser: StorageUserRepository
) : UserRepository {

    override fun loginUser(model: ProfileModel) {
        storageUser.saveUser(user = model)
    }

    override fun registUser(model: ProfileModel) {
        storageUser.saveUser(user = model)
    }

}