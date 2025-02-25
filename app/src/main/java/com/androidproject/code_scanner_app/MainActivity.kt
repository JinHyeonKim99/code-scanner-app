package com.androidproject.code_scanner_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenRoot
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreenRoot()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MainScreenRoot()
}