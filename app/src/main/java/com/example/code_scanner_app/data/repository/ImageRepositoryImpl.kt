package com.example.code_scanner_app.data.repository

import com.example.code_scanner_app.data.data_source.ImageDataSource
import com.example.code_scanner_app.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDataSource: ImageDataSource,
) : ImageRepository {
    override suspend fun setImage(image: ByteArray) {
        TODO("Not yet implemented")
    }
}