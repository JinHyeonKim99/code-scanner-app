package com.example.code_scanner_app.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.code_scanner_app.R

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    state: MainScreenState = MainScreenState(),
    onButtonClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        if (state.isAnswer) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "언어 : ${state.code.language}",
                    fontSize = 30.sp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .systemBarsPadding()
                )
                Text(
                    text = state.code.code,
                    fontSize = 20.sp,
                    color = Color.LightGray,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .horizontalScroll(
                            state = rememberScrollState()
                        )
                        .verticalScroll(
                            state = rememberScrollState()
                        )
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = R.drawable.camera_icon,
                    contentDescription = "이미지 스캔 버튼",
                    modifier = Modifier
                        .size(200.dp)
                        .aspectRatio(1f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(40.dp)
                        )
                        .clickable { onButtonClick() },
                    colorFilter = ColorFilter.tint(Color.LightGray),
                )

                Text(
                    modifier = Modifier
                        .width(290.dp)
                        .padding(top = 30.dp),
                    text = "아이콘을 눌러 코드를 스캔하세요",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.LightGray
                )
            }
        }
    }
}