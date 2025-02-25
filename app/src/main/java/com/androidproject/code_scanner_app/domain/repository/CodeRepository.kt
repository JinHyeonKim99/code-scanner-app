package com.androidproject.code_scanner_app.domain.repository

import android.graphics.Bitmap
import com.androidproject.code_scanner_app.domain.model.Code

interface CodeRepository {
    suspend fun getCode(prompt: String, image: Bitmap): Code
}