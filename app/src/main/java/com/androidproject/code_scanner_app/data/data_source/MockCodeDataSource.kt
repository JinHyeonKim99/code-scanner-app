package com.androidproject.code_scanner_app.data.data_source

import com.androidproject.code_scanner_app.domain.model.Code
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MockCodeDataSource @Inject constructor() : CodeDataSource {
    private val json = """
    {
        "language" : "kotlin",
        "code" : "fun main() {\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n}"
    }
""".trimIndent()

    override suspend fun getCode(): Code {
        return Json.decodeFromString<Code>(json)
    }
}