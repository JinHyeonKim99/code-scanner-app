package com.androidproject.code_scanner_app.data.reomote.data_source

import com.androidproject.code_scanner_app.domain.model.Image

interface ImageDataSource {
    suspend fun setImage(scanImage: Image)
}