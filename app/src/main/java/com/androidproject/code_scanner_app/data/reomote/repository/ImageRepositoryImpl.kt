package com.androidproject.code_scanner_app.data.reomote.repository

import com.androidproject.code_scanner_app.data.reomote.data_source.ImageDataSource
import com.androidproject.code_scanner_app.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDataSource: ImageDataSource,
) : ImageRepository {
    override suspend fun setImage(image: ByteArray) {
        TODO("Not yet implemented")
    }
}