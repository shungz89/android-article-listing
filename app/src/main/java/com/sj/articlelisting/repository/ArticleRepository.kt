package com.sj.articlelisting.repository

// ArticleRepository.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sj.articlelisting.api.RetrofitClient
import com.sj.articlelisting.models.Article
import com.sj.articlelisting.models.ArticleResponse
import com.sj.articlelisting.models.MostPopularArticle
import com.sj.articlelisting.models.MostPopularArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository {
    private val apiService = RetrofitClient.apiService

    fun getArticles(query: String): MutableLiveData<List<Article>?> {
        val data = MutableLiveData<List<Article>?>()
        apiService.getArticles(query).enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(
                call: Call<ArticleResponse>,
                response: Response<ArticleResponse>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()?.response?.docs
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    fun getMostEmailed(): MutableLiveData<List<MostPopularArticle>?> {
        val data = MutableLiveData<List<MostPopularArticle>?>()
        apiService.getMostEmailed().enqueue(object : Callback<MostPopularArticleResponse> {
            override fun onResponse(
                call: Call<MostPopularArticleResponse>,
                response: Response<MostPopularArticleResponse>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MostPopularArticleResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    fun getMostShared(): MutableLiveData<List<MostPopularArticle>?> {
        val data = MutableLiveData<List<MostPopularArticle>?>()
        apiService.getMostShared().enqueue(object : Callback<MostPopularArticleResponse> {
            override fun onResponse(
                call: Call<MostPopularArticleResponse>,
                response: Response<MostPopularArticleResponse>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MostPopularArticleResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    fun getMostViewed(): MutableLiveData<List<MostPopularArticle>?> {
        val data = MutableLiveData<List<MostPopularArticle>?>()
        apiService.getMostViewed().enqueue(object : Callback<MostPopularArticleResponse> {
            override fun onResponse(
                call: Call<MostPopularArticleResponse>,
                response: Response<MostPopularArticleResponse>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MostPopularArticleResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

}
