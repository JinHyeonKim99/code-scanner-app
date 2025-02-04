package com.androidproject.code_scanner_app.domain.repository

import com.androidproject.code_scanner_app.domain.model.Code

interface CodeRepository {
    suspend fun getCode(): Code
}