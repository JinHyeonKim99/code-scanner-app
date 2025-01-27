package com.example.code_scanner_app.domain.data_source

import com.example.code_scanner_app.domain.model.Code

interface CodeDataSource {
    suspend fun getCode(): Code
}