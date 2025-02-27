package com.androidproject.code_scanner_app.data.reomote.repository

import android.graphics.Bitmap
import android.net.Uri
import com.androidproject.code_scanner_app.data.reomote.data_source.CodeDataSource
import com.androidproject.code_scanner_app.domain.model.Code
import com.androidproject.code_scanner_app.domain.repository.CodeRepository
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val codeDataSource: CodeDataSource,
) : CodeRepository {
    override suspend fun getCode(prompt: String, uri: Uri): Code {
        return codeDataSource.getCode(prompt, uri)
    }
}