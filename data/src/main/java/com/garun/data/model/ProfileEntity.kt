package com.garun.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class ProfileEntity(
    @PrimaryKey val email: String,
    val userId: Int = 1,
    @ColumnInfo(name = "name_profile") val name: String,
    @ColumnInfo(name = "password_profile") val password: String,
)

