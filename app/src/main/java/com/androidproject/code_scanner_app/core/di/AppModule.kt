package com.androidproject.code_scanner_app.core.di

import com.androidproject.code_scanner_app.data.local.AppDatabase
import com.androidproject.code_scanner_app.data.local.dao.CodeDao
import com.androidproject.code_scanner_app.data.local.repository.CodeHistoryRepositoryImpl
import com.androidproject.code_scanner_app.data.reomote.data_source.MockImageDataSourceImpl
import com.androidproject.code_scanner_app.data.reomote.repository.CodeRepositoryImpl
import com.androidproject.code_scanner_app.data.reomote.repository.ImageRepositoryImpl
import com.androidproject.code_scanner_app.data.reomote.data_source.CodeDataSource
import com.androidproject.code_scanner_app.data.reomote.data_source.CodeDataSourceImpl
import com.androidproject.code_scanner_app.data.reomote.data_source.ImageDataSource
import com.androidproject.code_scanner_app.data.reomote.data_source.MockCodeDataSourceImpl
import com.androidproject.code_scanner_app.domain.repository.CodeHistoryRepository
import com.androidproject.code_scanner_app.domain.repository.CodeRepository
import com.androidproject.code_scanner_app.domain.repository.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindCodeDataSource(codeDataSource: CodeDataSourceImpl): CodeDataSource

//    @Singleton
//    @Binds
//    abstract fun bindMockCodeDataSource(codeDataSource: MockCodeDataSourceImpl): CodeDataSource

    @Singleton
    @Binds
    abstract fun bindImageDataSource(imageDataSource: MockImageDataSourceImpl): ImageDataSource

    @Singleton
    @Binds
    abstract fun bindCodeRepository(codeRepository: CodeRepositoryImpl): CodeRepository

    @Singleton
    @Binds
    abstract fun bindImageRepository(imageRepository: ImageRepositoryImpl): ImageRepository

    @Singleton
    @Binds
    abstract fun bindCodeHistoryRepository(codeHistoryRepository: CodeHistoryRepositoryImpl): CodeHistoryRepository
}