package com.filensablon.app.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filensablon.app.data.model.ActionState
import com.filensablon.app.data.model.News
import com.filensablon.app.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val repo: NewsRepository by lazy { NewsRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<News>>()


    fun listNews(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listNews()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }


}