package com.androidproject.code_scanner_app.data.reomote.data_source

import android.net.Uri
import com.androidproject.code_scanner_app.domain.model.Code
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MockCodeDataSourceImpl @Inject constructor() : CodeDataSource {
    private val json = """
    {
        "id" : "0",
        "code" : "```kotlin\nfun main() {\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n\n    println(\"Hello World!\")\n}\n```"
    }
""".trimIndent()

    override suspend fun getCode(prompt: String, uri: Uri): Code {
        delay(1000)
        return Json.decodeFromString<Code>(json)
    }
}