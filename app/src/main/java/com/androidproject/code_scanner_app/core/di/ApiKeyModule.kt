package com.androidproject.code_scanner_app.core.di

import com.androidproject.code_scanner_app.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // 앱 전체에서 사용 가능
object ApiKeyModule {

    @Provides
    @Singleton
    fun provideApiKey(): String {
        return BuildConfig.OPENAI_API_KEY // BuildConfig에서 API 키 제공
    }
}