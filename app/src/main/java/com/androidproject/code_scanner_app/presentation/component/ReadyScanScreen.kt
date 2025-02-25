package com.androidproject.code_scanner_app.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.androidproject.code_scanner_app.R
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenAction

@Composable
fun ReadyScanScreen(
    modifier: Modifier = Modifier,
    isLandscape: Boolean = false,
    onAction: (MainScreenAction) -> Unit,
) {
    if (isLandscape) {
        Column(
            modifier = modifier
                .padding(horizontal = 60.dp)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
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
                        .clickable { onAction(MainScreenAction.OnCameraButtonClick) },
                    colorFilter = ColorFilter.tint(Color.LightGray),
                )

                Spacer(modifier = Modifier.width(40.dp))

                AsyncImage(
                    model = R.drawable.gallery_icon,
                    contentDescription = "이미지 스캔 버튼",
                    modifier = Modifier
                        .size(200.dp)
                        .aspectRatio(1f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(40.dp)
                        )
                        .clickable { onAction(MainScreenAction.OnGalleryButtonClick) },
                    colorFilter = ColorFilter.tint(Color.LightGray),
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "촬영 아이콘을 눌러 코드를 스캔하거나\n갤러리에서 사진을 선택해주세요",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.LightGray
            )
        }
    } else {
        Column(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = R.drawable.camera_icon,
                    contentDescription = "이미지 스캔 버튼",
                    modifier = Modifier
                        .size(180.dp)
                        .aspectRatio(1f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(40.dp)
                        )
                        .clickable { onAction(MainScreenAction.OnCameraButtonClick) },
                    colorFilter = ColorFilter.tint(Color.LightGray),
                )

                Spacer(modifier = Modifier.width(20.dp))

                AsyncImage(
                    model = R.drawable.gallery_icon,
                    contentDescription = "이미지 스캔 버튼",
                    modifier = Modifier
                        .size(180.dp)
                        .aspectRatio(1f)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(40.dp)
                        )
                        .clickable { onAction(MainScreenAction.OnGalleryButtonClick) },
                    colorFilter = ColorFilter.tint(Color.LightGray),
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "촬영 아이콘을 눌러 코드를 스캔하거나\n갤러리에서 사진을 선택해주세요",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = Color.LightGray
            )
        }
    }
}