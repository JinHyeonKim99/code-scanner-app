package com.androidproject.code_scanner_app.data.data_source

import com.androidproject.code_scanner_app.domain.model.Image
import javax.inject.Inject

class MockImageDataSourceImpl @Inject constructor() : ImageDataSource {
    override suspend fun setImage(scanImage: Image) {
        TODO("Not yet implemented")
    }
}