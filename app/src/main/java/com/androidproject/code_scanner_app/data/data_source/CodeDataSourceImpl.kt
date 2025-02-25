package com.androidproject.code_scanner_app.data.data_source

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import com.androidproject.code_scanner_app.BuildConfig
import com.androidproject.code_scanner_app.domain.model.Code
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class CodeDataSourceImpl @Inject constructor(
    private val context: Context,
) : CodeDataSource {
    private val apiKey: String = BuildConfig.OPENAI_API_KEY
    private val client = HttpClient(CIO)
    private val json = Json {
        ignoreUnknownKeys = true // 🔥 예상치 못한 키 무시
        encodeDefaults = true
        prettyPrint = true
        isLenient = true
    }

    override suspend fun getCode(prompt: String, uri: Uri): Code {
        val outputStream = ByteArrayOutputStream()
        uriToBitmap(context, uri)?.compress(
            Bitmap.CompressFormat.JPEG,
            100,
            outputStream
        )  // 압축률 100%로 설정
        val byteArray = outputStream.toByteArray()
        val base64 = Base64.encodeToString(byteArray, Base64.DEFAULT)

        val requestData = OpenAIRequest(
            model = "gpt-4o-mini",
            messages = listOf(
                MessageRequest(
                    role = "user",
                    content = listOf(
                        Content.Text(prompt),
//                        Content.Image(ImageUrl("data:image/jpeg;base64,$base64"))
                        Content.Image(ImageUrl("https://cdn.inflearn.com/public/files/posts/986a146c-9d95-45c3-bb95-d91327761358/%EB%A6%AC%EC%95%A1%ED%8A%B8%20%EC%A7%88%EB%AC%B8.JPG"))
                    )
                )
            )
        )

        // 🔥 JSON 직렬화를 여기서 수행하여 올바른 JSON 형식 유지
        val requestJson = json.encodeToString(requestData)

        println(requestJson)


        val response = client.post("https://api.openai.com/v1/chat/completions") {
            headers {
                append(HttpHeaders.Authorization, "Bearer $apiKey")
                append(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            }
            setBody(requestJson) // 🔥 올바른 JSON 데이터 전달
        }

        val jsonBody = response.bodyAsText()
        println(jsonBody)
        val openAIResponse = json.decodeFromString<OpenAIResponse>(jsonBody)

        return Code(
            "",
            (openAIResponse.choices?.firstOrNull()?.message?.content ?: "응답이 없습니다").toString()
        )
    }

    // 🔹 URI → Bitmap 변환 함수
    private fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

@Serializable
data class OpenAIRequest(
    val model: String = "gpt-4o",
    val messages: List<MessageRequest>,
)

@Serializable
data class MessageRequest(
    val role: String,
    val content: List<Content>,
)

@Serializable
data class MessageResponse(
    val role: String,
    val content: String,
)

@Serializable
sealed class Content {

    @Serializable
    @SerialName("text")
    data class Text(val text: String) : Content()

    @Serializable
    @SerialName("image_url")
    data class Image(@SerialName("image_url") val imageUrl: ImageUrl) : Content()
}

@Serializable
data class ImageUrl(val url: String)

@Serializable
data class OpenAIResponse(
    val choices: List<Choice>? = null,
    val error: OpenAIError? = null,
)

@Serializable
data class Choice(
    val message: MessageResponse,
)

@Serializable
data class OpenAIError(
    val message: String,
)
