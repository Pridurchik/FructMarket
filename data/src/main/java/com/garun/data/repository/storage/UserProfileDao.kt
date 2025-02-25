package com.garun.data.repository.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.garun.data.model.ProfileEntity

@Dao
interface UserProfileDao {

    @Insert
    fun insertProfileUser(profileEntity: ProfileEntity)

    @Query(value = "SELECT * FROM users")
    fun getUserProfile() : List<ProfileEntity>

    @Delete
    fun delete(user: ProfileEntity)

}