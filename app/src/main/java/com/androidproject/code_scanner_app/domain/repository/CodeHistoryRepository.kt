package com.androidproject.code_scanner_app.domain.repository

import com.androidproject.code_scanner_app.domain.model.Code

interface CodeHistoryRepository {
    suspend fun getAllCodeHistory(): List<Code>
    suspend fun getCodeHistoryById(id: Int): Code
    suspend fun getCodeCount(): Int
    suspend fun updateHistory(code: Code)
    suspend fun deleteHistoryById(id: Int)
    suspend fun deleteAllHistory()
}