package com.androidproject.code_scanner_app.data.local.mapper

import com.androidproject.code_scanner_app.data.local.entity.CodeEntity
import com.androidproject.code_scanner_app.domain.model.Code

fun CodeEntity.toCode() = Code(
    id = id,
    code = code
)

fun Code.toCodeEntity() = CodeEntity(
    primaryKey = 0,
    id = id,
    code = code,
)