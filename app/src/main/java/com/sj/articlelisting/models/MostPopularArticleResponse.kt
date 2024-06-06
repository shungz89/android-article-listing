package com.sj.articlelisting.models

data class MostPopularArticleResponse(
    val status: String,
    val copyright: String,
    val results: List<MostPopularArticle>,
)

data class MostPopularArticle(
    val title: String?,
    val published_date: String?,
)