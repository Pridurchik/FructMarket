package com.garun.fructmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room.databaseBuilder
import com.garun.base.theme.FructMarketTheme
import com.garun.data.repository.storage.AppDatabase
import com.garun.features.choosing_enter.ui.ChoosingScreen
import com.garun.features.login.ui.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FructMarketTheme {
                Scaffold(
                    containerColor = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(paddingValues = it)
                    ) {
                        LoginScreen()
                    }
                }
            }
        }
    }

}


