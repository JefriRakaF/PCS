package com.filensablon.app.data.remote


import com.filensablon.app.data.model.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    fun listNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsList?>?


}