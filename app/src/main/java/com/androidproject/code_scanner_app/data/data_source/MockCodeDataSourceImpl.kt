package com.androidproject.code_scanner_app.data.data_source

import android.net.Uri
import com.androidproject.code_scanner_app.domain.model.Code
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MockCodeDataSourceImpl @Inject constructor() : CodeDataSource {
    private val json = """
    {
        "language" : "kotlin",
        "code" : "```kotlin\nfun main() {\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n}\n```"
    }
""".trimIndent()

    override suspend fun getCode(prompt: String, uri: Uri): Code {
        return Json.decodeFromString<Code>(json)
    }
}