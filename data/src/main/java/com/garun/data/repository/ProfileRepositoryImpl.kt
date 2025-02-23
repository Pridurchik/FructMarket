package com.garun.data.repository

import com.garun.base.model.ProfileModel
import com.garun.base.repository.ProfileRepository
import com.garun.data.repository.storage.AppDatabase

class ProfileRepositoryImpl(
    private val appDatabase: AppDatabase
) : ProfileRepository {
    override fun isEnter(): Boolean {
        val users = appDatabase.getUserProfileDao().getUserProfile()
        val result = users.isNotEmpty()

        return result
    }

    override fun getProfile(): ProfileModel {
        return ProfileModel(
            name = "",
            email = "",
            password = ""
        )
    }

}