package com.androidproject.code_scanner_app.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    isLandscape: Boolean = false,
) {
    Column(
        modifier = if (isLandscape) {
            modifier
                .wrapContentSize() // Column 크기를 내용에 맞게 조정
                .padding(vertical = 60.dp)
        } else {
            modifier
                .wrapContentSize() // Column 크기를 내용에 맞게 조정
        },
        verticalArrangement = Arrangement.spacedBy(20.dp), // 내부 요소를 중앙 정렬
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "코드를 추출하는 중입니다",
            fontSize = 27.sp,
            color = Color.White,
            modifier = Modifier
        )

        CircularProgressIndicator(
            modifier = Modifier.size(200.dp),
            strokeWidth = 8.dp // 선 두께 조정
        )
    }
}

@Preview
@Composable
private fun test() {
    LoadingAnimation()
}