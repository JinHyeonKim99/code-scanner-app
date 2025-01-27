package com.example.code_scanner_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Code(
    val language: String,
    val code: String,
)