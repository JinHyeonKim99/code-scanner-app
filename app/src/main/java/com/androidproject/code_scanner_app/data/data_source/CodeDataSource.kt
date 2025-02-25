package com.androidproject.code_scanner_app.data.data_source

import android.net.Uri
import com.androidproject.code_scanner_app.domain.model.Code

interface CodeDataSource {
    suspend fun getCode(prompt: String, uri: Uri): Code
}