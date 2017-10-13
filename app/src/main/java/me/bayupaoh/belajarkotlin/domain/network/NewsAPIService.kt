package me.bayupaoh.belajarkotlin.domain.network

import me.bayupaoh.belajarkotlin.domain.model.response.NewsResponse
import me.bayupaoh.belajarkotlin.util.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by King Oil on 12/10/2017.
 */
interface NewsAPIService {
    @GET("feeds/newsdefaultfeeds.cms?feedtype=sjson")
    fun getNews(): Observable<NewsResponse>

    class Factory{
        companion object {
            fun create(): NewsAPIService {
                val retrofit = Retrofit.Builder()
                        .baseUrl(Constants.NEWS_ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                        .build()
                return retrofit.create(NewsAPIService::class.java)
            }
        }
    }
}