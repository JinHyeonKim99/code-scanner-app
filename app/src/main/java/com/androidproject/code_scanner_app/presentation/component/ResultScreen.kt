package com.androidproject.code_scanner_app.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenAction
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenState

@Composable
fun ResultScreen(
    modifier: Modifier,
    state: MainScreenState,
    isLandscape: Boolean = false,
    onAction: (MainScreenAction) -> Unit,
) {
    if (state.isLoading) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier)

            LoadingAnimation(isLandscape = isLandscape)

            Spacer(modifier = Modifier)
        }
    } else {
        Column(
            modifier = if (isLandscape) {
                modifier
                    .fillMaxSize()
                    .padding(vertical = 25.dp)
            } else {
                modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            },
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Text(
                text = "결과",
                fontSize = 27.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = state.code.code,
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        start = if (isLandscape) 55.dp else 15.dp,
                    )
                    .horizontalScroll(
                        state = rememberScrollState()
                    )
                    .verticalScroll(
                        state = rememberScrollState()
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = if (isLandscape) 300.dp else 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                // 복사 버튼을 화면 중앙에 배치하기 위해 공유 버튼과 크기가 같은 투명 텍스트 배치
                Text(
                    text = "뒤로",
                    fontSize = 23.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(6.dp)
                        .clickable {
                            onAction(MainScreenAction.OnBackButtonClick)
                        }
                )

                // 🔹 첫 번째 버튼을 화면 중앙에 배치
                Text(
                    text = "클립 보드에 복사",
                    fontSize = 23.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(6.dp)
                        .clickable {
                            onAction(MainScreenAction.OnCopyButtonClick)
                        }
                )

                // 두 번째 버튼을 화면 오른쪽에 배치
                Text(
                    text = "공유",
                    fontSize = 23.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(6.dp)
                        .clickable {
                            onAction(MainScreenAction.OnShareButtonClick)
                        }
                )
            }
        }
    }
}