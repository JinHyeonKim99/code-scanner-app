package com.example.code_scanner_app.domain.repository

import com.example.code_scanner_app.domain.model.Code

interface CodeRepository {
    suspend fun getCode(): Code
}