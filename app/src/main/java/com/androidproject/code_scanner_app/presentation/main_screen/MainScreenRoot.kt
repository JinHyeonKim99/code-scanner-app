package com.androidproject.code_scanner_app.presentation.main_screen

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreenRoot(
) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
//    val activity = context as? Activity
    // 🔹 권한 요청을 위한 런처
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.d("MainScreenRoot", "카메라 권한이 허용됨")
        } else {
            Log.e("MainScreenRoot", "카메라 권한이 거부됨")
        }
    }

    // 🔹 카메라 권한 확인
    val isCameraPermissionGranted = remember {
        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    // 🔹 사진을 찍고 Bitmap을 직접 반환하는 런처
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if (bitmap != null) {
            Log.d("MainScreenRoot", "사진이 성공적으로 찍힘")
            viewModel.onButtonClick(bitmap)  // 뷰모델로 전달
        } else {
            Log.e("MainScreenRoot", "사진 촬영 실패")
        }
    }

    MainScreen(
        state = state,
        onButtonClick = { launcher.launch() }
    )
}