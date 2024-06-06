// ApiService.kt
package com.sj.articlelisting.api

import com.sj.articlelisting.models.ArticleResponse
import com.sj.articlelisting.models.MostPopularArticle
import com.sj.articlelisting.models.MostPopularArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/v2/articlesearch.json")
    fun getArticles(
        @Query("q") query: String
    ): Call<ArticleResponse>


    @GET("mostpopular/v2/emailed/7.json")
    fun getMostEmailed(
    ): Call<MostPopularArticleResponse>

    @GET("mostpopular/v2/shared/1/facebook.json")
    fun getMostShared(
    ): Call<MostPopularArticleResponse>

    @GET("mostpopular/v2/viewed/1.json")
    fun getMostViewed(
    ): Call<MostPopularArticleResponse>


}
