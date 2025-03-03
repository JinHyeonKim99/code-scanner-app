package com.androidproject.code_scanner_app.core.di

import android.content.Context
import androidx.room.Room
import com.androidproject.code_scanner_app.data.local.AppDatabase
import com.androidproject.code_scanner_app.data.local.dao.CodeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "code.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCodeDao(database: AppDatabase): CodeDao {
        return database.codeDao()
    }
}