package com.androidproject.code_scanner_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.androidproject.code_scanner_app.data.local.entity.CodeEntity

@Dao
interface CodeDao {
    @Query("SELECT * FROM code ORDER BY id ASC")
    suspend fun getAllCode(): List<CodeEntity>

    @Query("SELECT * FROM code WHERE id = :id")
    suspend fun getCodeById(id: Int): CodeEntity

    @Query("SELECT COUNT(*) FROM code")
    suspend fun getCodeCount(): Int

    // 특정 코드 삭제
    @Transaction
    suspend fun deleteAndRearrange(codeId: Int) {
        deleteCodeById(codeId) // 특정 ID 삭제
        rearrangeIds(codeId)   // 삭제된 ID 이후의 ID들을 앞으로 당기기
    }

    @Query("DELETE FROM code WHERE id = :codeId")
    suspend fun deleteCodeById(codeId: Int)

    @Query("UPDATE code SET id = id - 1 WHERE id > :deletedId")
    suspend fun rearrangeIds(deletedId: Int)

    // 새로운 코드 추가 (최대 10개 유지)
    @Transaction
    suspend fun insertWithLimit(newCode: CodeEntity) {
        val count = getCodeCount()
        if (count >= 10) {
            deleteOldestCode() // 가장 오래된 코드 삭제 (id가 가장 작은 값)
            rearrangeIds(1)    // ID 재정렬
        }
        insertCode(newCode) // 새 코드 추가
    }

    @Insert
    suspend fun insertCode(code: CodeEntity)

    @Query("DELETE FROM code WHERE id = (SELECT MIN(id) FROM code)")
    suspend fun deleteOldestCode()

    @Query("DELETE FROM code")
    suspend fun deleteAllCode()
}