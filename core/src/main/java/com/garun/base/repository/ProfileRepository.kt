package com.garun.base.repository

import com.garun.base.model.ProfileModel


/**
    @param test
*/

interface ProfileRepository {

    fun isEnter(): Boolean

    fun getProfile() : ProfileModel

}