package com.androidproject.code_scanner_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidproject.code_scanner_app.data.local.dao.CodeDao
import com.androidproject.code_scanner_app.data.local.entity.CodeEntity

@Database(entities = [CodeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun codeDao(): CodeDao
}