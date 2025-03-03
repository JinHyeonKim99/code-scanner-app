package com.androidproject.code_scanner_app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "code")
class CodeEntity(
    @PrimaryKey(autoGenerate = true) val primaryKey: Int = 0, // 자동 증가 설정
    @ColumnInfo(defaultValue = "0") val id: Int,
    @ColumnInfo(defaultValue = "''") val code: String,
)