package com.garun.data

import android.util.Log
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.garun.base.model.ProfileModel
import com.garun.data.repository.ProfileRepositoryImpl
import com.garun.data.repository.UserRepositoryImpl
import com.garun.data.repository.storage.AppDatabase
import com.garun.data.repository.storage.StorageUserRepositoryImpl
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun testSaveUserRoom() {

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val db = Room.databaseBuilder(
            context = appContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val userRepository = UserRepositoryImpl(
            storageUser = StorageUserRepositoryImpl(
                appDatabase = db
            )
        )

        userRepository.loginUser(
            ProfileModel(
                name = "Garun",
                email = "magomedovgarun02@gmail.com",
                password = "123123123"
            )
        )


        val profile_repo = ProfileRepositoryImpl(
            appDatabase = db
        ).isEnter()
        val res = db.getUserProfileDao().getUserProfile()

        Log.e("TestRoo", res.toString())
        Log.e("TestRoo", profile_repo.toString())

    }
}