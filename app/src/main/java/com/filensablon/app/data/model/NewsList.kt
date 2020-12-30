package com.filensablon.app.data.model

data class NewsList(
    val status: String = "",
    val totalResults: Int = 0,
    val articles: List<News> = arrayListOf()


)
