package me.bayupaoh.belajarkotlin.presentation.main

import me.bayupaoh.belajarkotlin.domain.model.NewsItem

/**
 * Created by King Oil on 12/10/2017.
 */
interface MainContract {
    fun onNewsItemLoaded(newsItems: List<NewsItem>)

    fun onError(throwable: Throwable?)

    fun hideLoading()
}