package com.example.code_scanner_app.domain.repository

interface ImageRepository {
    suspend fun setImage(image: ByteArray)
}