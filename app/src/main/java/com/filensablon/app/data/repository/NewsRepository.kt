package com.filensablon.app.data.repository

import com.filensablon.app.data.model.ActionState
import com.filensablon.app.data.model.News
import com.filensablon.app.data.remote.NewsService
import com.filensablon.app.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>>{
       return try {
            val list = newsService.listNews("id" , "8af3eaa66f2b43109a9ca8c280696dc7")?.await()
            ActionState(list?.articles)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }



}