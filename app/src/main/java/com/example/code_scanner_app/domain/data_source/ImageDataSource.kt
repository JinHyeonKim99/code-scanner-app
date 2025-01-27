package com.example.code_scanner_app.domain.data_source

import com.example.code_scanner_app.domain.model.Image

interface ImageDataSource {
    suspend fun setImage(scanImage: Image)
}