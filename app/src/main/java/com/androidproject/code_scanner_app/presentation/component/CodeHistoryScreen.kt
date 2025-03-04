package com.androidproject.code_scanner_app.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenAction
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenState


@Composable
fun CodeHistoryScreen(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    isLandscape: Boolean,
    onAction: (MainScreenAction) -> Unit,
) {
    Column(
        modifier = if (isLandscape) modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(bottom = 10.dp)
            .padding(horizontal = 70.dp)
        else modifier
            .fillMaxSize()
            .padding(bottom = 40.dp, top = 10.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = modifier
                .height(if (isLandscape) 280.dp else 770.dp)
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(if (isLandscape) 10.dp else 20.dp),
        ) {
            itemsIndexed(state.codeHistory) { id, code ->
                Row(
                    modifier = modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = code.code,
                        color = Color.White,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                onAction(MainScreenAction.OnCodeButtonCLick(code.id))
                            },
                        fontSize = 25.sp,
                        maxLines = 2, // 🔥 한 줄만 표시
                        overflow = TextOverflow.Ellipsis // 🔥 내용이 길면 "..." 처리
                    )

                    IconButton(
                        onClick = { onAction(MainScreenAction.OnDeleteButtonClick(code.id)) }
                    ) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "삭제")
                    }
                }
            }
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(100.dp),
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
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
                        },
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "비우기",
                    fontSize = 23.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(6.dp)
                        .clickable {
                            onAction(MainScreenAction.OnDeleteAllButton)
                        },
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun test1() {
    CodeHistoryScreen(
        modifier = Modifier,
        state = MainScreenState(),
        isLandscape = false,
        onAction = {}
    )
}