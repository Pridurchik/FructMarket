package com.garun.data.repository.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.garun.data.model.ProfileEntity

@Database(
    version = 1,
    entities = [
        ProfileEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun  getUserProfileDao(): UserProfileDao

}