package com.sj.articlelisting.models

import com.google.gson.annotations.SerializedName

// ArticleResponse.kt
data class ArticleResponse(
    val status: String,
    val copyright: String,
    val response: Response
)

data class Response(
    val docs: List<Article>,
    val meta: Meta
)

data class Article(
    val abstract: String,
    val web_url: String,
    val snippet: String,
    val lead_paragraph: String,
    val headline: Headline,
    val source: String,
    val pub_date: String,
    val document_type: String,
    val news_desk: String,
    val section_name: String,
    val subsection_name: String?,
    val byline: Byline?,
    val _id: String,
    val word_count: Int,
    val uri: String,
)

data class Headline(
    val main: String,
    val kicker: String?,
    @SerializedName("content_kicker")
    val contentKicker: String?,
    @SerializedName("print_headline")
    val printHeadline: String?,
    val name: String?,
    val seo: String?,
    val sub: String?
)

data class Byline(
    val original: String?,
    val organization: String?
)

data class Meta(
    val hits: Int,
    val offset: Int,
    val time: Int
)
