package com.androidproject.code_scanner_app.data.local.repository

import com.androidproject.code_scanner_app.data.local.dao.CodeDao
import com.androidproject.code_scanner_app.data.local.mapper.toCode
import com.androidproject.code_scanner_app.data.local.mapper.toCodeEntity
import com.androidproject.code_scanner_app.domain.model.Code
import com.androidproject.code_scanner_app.domain.repository.CodeHistoryRepository
import javax.inject.Inject

class CodeHistoryRepositoryImpl @Inject constructor(
    private val dao: CodeDao,
) : CodeHistoryRepository {

    override suspend fun getAllCodeHistory(): List<Code> {
        return dao.getAllCode().map { it.toCode() }
    }

    override suspend fun getCodeHistoryById(id: Int): Code {
        return dao.getCodeById(id).toCode()
    }

    override suspend fun getCodeCount(): Int {
        return dao.getCodeCount()
    }

    override suspend fun updateHistory(code: Code) {
        dao.insertCode(code.toCodeEntity())
    }

    override suspend fun deleteHistoryById(id: Int) {
        dao.deleteCodeById(id)
    }

    override suspend fun deleteAllHistory() {
        dao.deleteAllCode()
    }
}