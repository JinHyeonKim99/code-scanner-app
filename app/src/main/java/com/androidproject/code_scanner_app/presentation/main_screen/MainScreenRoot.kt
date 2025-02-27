package com.androidproject.code_scanner_app.presentation.main_screen

import android.Manifest
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.*
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.io.File

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

    // 🔹 파일을 저장할 임시 URI 생성
    val file = remember { File(context.cacheDir, "captured_photo.jpg") }
    val uri = remember { FileProvider.getUriForFile(context, "${context.packageName}.provider", file) }

    // 🔹 사진을 찍고 URI를 반환하는 런처
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
            if (success) {
                Log.d("MainScreenRoot", "사진이 성공적으로 찍힘")
                viewModel.onCameraButtonClick(uri)  // 뷰모델로 전달
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

    // 가로 세로 구분
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    // 클립보드 사용
    val clipboardManager = LocalClipboardManager.current

    MainScreen(
        state = state,
        isLandscape = isLandscape,
        onAction = { action ->
            when (action) {
                is MainScreenAction.OnCameraButtonClick -> {
                    cameraLauncher.launch(uri)
                }
                is MainScreenAction.OnGalleryButtonClick -> {
                    galleryLauncher.launch("image/*")
                }
                is MainScreenAction.OnCopyButtonClick -> {
                    clipboardManager.setText(AnnotatedString(state.code.code))
                    Toast.makeText(context, "클립보드에 복사됨", Toast.LENGTH_SHORT).show()
                }
            }
        },
    )
}