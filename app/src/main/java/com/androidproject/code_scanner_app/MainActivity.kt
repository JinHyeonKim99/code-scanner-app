package com.androidproject.code_scanner_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreen
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val mainScreenViewModel: MainScreenViewModel = hiltViewModel()

            val mainScreenState by mainScreenViewModel.state.collectAsState()

            MainScreen(
                state = mainScreenState,
                onButtonClick = { mainScreenViewModel.onButtonClick() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MainScreen()
}