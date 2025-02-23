package com.garun.data.repository.storage

import com.garun.base.model.ProfileModel
import com.garun.data.model.ProfileEntity
import com.garun.data.repository.storage_repo.StorageUserRepository

class StorageUserRepositoryImpl(
    private val appDatabase: AppDatabase
): StorageUserRepository {

    override fun saveUser(user: ProfileModel) {
        val userDao = appDatabase.getUserProfileDao()
        userDao.insertProfileUser(
            ProfileEntity(
                email = user.email,
                name = user.name,
                password = user.password
            )
        )
    }

    override fun getUser(): ProfileModel {
        val userDao = appDatabase.getUserProfileDao()
        val model = userDao.getUserProfile()

        return ProfileModel(
            name = model[0].name,
            email = model[0].email,
            password = model[0].password
        )

    }
}