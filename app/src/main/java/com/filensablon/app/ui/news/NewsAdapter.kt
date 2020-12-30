package com.filensablon.app.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.filensablon.app.R
import com.filensablon.app.data.model.News
import com.filensablon.app.databinding.ItemNewsBinding
import com.filensablon.app.ui.base.BaseAdapter

class NewsAdapter (val context: Context) : BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.urlToImage).into(mBinding.itemUrlToImage)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}