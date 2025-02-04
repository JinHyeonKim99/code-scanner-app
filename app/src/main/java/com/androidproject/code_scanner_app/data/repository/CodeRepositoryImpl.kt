package com.androidproject.code_scanner_app.data.repository

import com.androidproject.code_scanner_app.data.data_source.CodeDataSource
import com.androidproject.code_scanner_app.domain.model.Code
import com.androidproject.code_scanner_app.domain.repository.CodeRepository
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val codeDataSource: CodeDataSource,
) : CodeRepository {
    override suspend fun getCode(): Code {
        return codeDataSource.getCode()
    }
}