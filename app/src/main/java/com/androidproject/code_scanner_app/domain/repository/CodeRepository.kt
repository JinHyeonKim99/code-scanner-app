package com.androidproject.code_scanner_app.domain.repository

import android.net.Uri
import com.androidproject.code_scanner_app.domain.model.Code

interface CodeRepository {
    suspend fun getCode(prompt: String, uri: Uri): Code
}