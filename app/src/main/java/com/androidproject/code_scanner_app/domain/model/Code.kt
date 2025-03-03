package com.androidproject.code_scanner_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Code(
    val id: Int = 0,
    val code: String,
)