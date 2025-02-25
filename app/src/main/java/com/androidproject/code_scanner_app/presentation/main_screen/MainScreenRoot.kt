package com.androidproject.code_scanner_app.presentation.main_screen

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    // 🔹 사진을 찍고 Bitmap을 직접 반환하는 런처
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            if (bitmap != null) {
                Log.d("MainScreenRoot", "사진이 성공적으로 찍힘")
                viewModel.onCameraButtonClick(bitmap)  // 뷰모델로 전달
            } else {
                Log.e("MainScreenRoot", "사진 촬영 실패")
            }
        }

    // 🔹 갤러리에서 사진을 선택하는 런처
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            Log.d("MainScreenRoot", "갤러리에서 사진 선택됨: $uri")
            viewModel.onGalleryButtonClick(uri) // Uri를 그대로 뷰모델로 전달
        } ?: Log.e("MainScreenRoot", "갤러리에서 사진 선택 실패")
    }

    val configuration = LocalConfiguration.current

    // 화면 방향에 따라 패딩 값 설정
    val horizontalPadding = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> 40.dp // 가로 모드일 때 패딩 증가
        else -> 15.dp // 기본(세로 모드) 패딩
    }

    MainScreen(
        state = state,
        horizontalPadding = horizontalPadding,
        onButtonClick = { galleryLauncher.launch("image/*") }
    )
}