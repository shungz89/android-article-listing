package com.sj.articlelisting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sj.articlelisting.models.Article
import com.sj.articlelisting.models.MostPopularArticle
import com.sj.articlelisting.repository.ArticleRepository

class ArticleViewModel : ViewModel() {
    private val repository = ArticleRepository()

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun getArticles(query: String): MutableLiveData<List<Article>?> {
        _loadingState.value = true
        val articlesLiveData = repository.getArticles(query)
        articlesLiveData.observeForever {
            _loadingState.value = false
        }
        return articlesLiveData
    }

    fun getMostEmailed(): MutableLiveData<List<MostPopularArticle>?> {
        _loadingState.value = true
        val articlesLiveData = repository.getMostEmailed()
        articlesLiveData.observeForever {
            _loadingState.value = false
        }
        return articlesLiveData
    }

    fun getMostShared(): MutableLiveData<List<MostPopularArticle>?> {
        _loadingState.value = true
        val articlesLiveData = repository.getMostShared()
        articlesLiveData.observeForever {
            _loadingState.value = false
        }
        return articlesLiveData
    }

    fun getMostViewed(): MutableLiveData<List<MostPopularArticle>?> {
        _loadingState.value = true
        val articlesLiveData = repository.getMostViewed()
        articlesLiveData.observeForever {
            _loadingState.value = false
        }
        return articlesLiveData
    }


}
