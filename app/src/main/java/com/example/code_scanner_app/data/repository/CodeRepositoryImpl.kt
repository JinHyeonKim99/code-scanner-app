package com.example.code_scanner_app.data.repository

import com.example.code_scanner_app.domain.data_source.CodeDataSource
import com.example.code_scanner_app.domain.model.Code
import com.example.code_scanner_app.domain.repository.CodeRepository
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val codeDataSource: CodeDataSource,
) : CodeRepository {
    override suspend fun getCode(): Code {
        return codeDataSource.getCode()
    }
}