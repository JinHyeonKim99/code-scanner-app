package com.androidproject.code_scanner_app.core.di

import com.androidproject.code_scanner_app.data.data_source.MockCodeDataSource
import com.androidproject.code_scanner_app.data.data_source.MockImageDataSource
import com.androidproject.code_scanner_app.data.repository.CodeRepositoryImpl
import com.androidproject.code_scanner_app.data.repository.ImageRepositoryImpl
import com.androidproject.code_scanner_app.data.data_source.CodeDataSource
import com.androidproject.code_scanner_app.data.data_source.ImageDataSource
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
    abstract fun provideCodeDataSource(
        codeDataSource: MockCodeDataSource,
    ): CodeDataSource

    @Singleton
    @Binds
    abstract fun provideImageDataSource(
        imageDataSource: MockImageDataSource,
    ): ImageDataSource

    @Singleton
    @Binds
    abstract fun provideCodeRepository(codeRepository: CodeRepositoryImpl): CodeRepository

    @Singleton
    @Binds
    abstract fun provideImageRepository(imageRepository: ImageRepositoryImpl): ImageRepository
}