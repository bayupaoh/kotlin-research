package me.bayupaoh.belajarkotlin.presentation.main

import android.util.Log
import com.google.gson.Gson
import io.realm.Realm
import me.bayupaoh.belajarkotlin.domain.model.NewsItem
import me.bayupaoh.belajarkotlin.domain.network.NewsAPIService
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by King Oil on 12/10/2017.
 */
class MainPresenter {
    private var mNewsAPIService: NewsAPIService? = null

    private var mNewsView: MainContract? = null

    private var subsciption: Subscription? = null

    fun onViewCreated(view: MainContract) {
        mNewsView = view
    }

    fun setNewsAPIInterface(newsAPIService: NewsAPIService) {
        this.mNewsAPIService = newsAPIService
    }

    fun loadNews() {
        Log.i("lapar","eksekusi")
        subsciption = mNewsAPIService!!.getNews()
                .map { it.newsItem }
                .flatMap({ items ->
                    Realm.getDefaultInstance().executeTransaction({ realm ->
                        realm.delete(NewsItem::class.java)
                        realm.insert(items)
                    })
                    Observable.just(items)
                })
                .onErrorResumeNext { throwable ->
                    val realm = Realm.getDefaultInstance()
                    val items = realm.where(NewsItem::class.java).findAll()
                    Observable.just(realm.copyFromRealm(items))
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mNewsView?.hideLoading() }
                .subscribe({
                    mNewsView?.onNewsItemLoaded(it)
                    Log.i("lapar",Gson().toJson(it))
                }, { mNewsView?.onError(it) })
    }

    fun onDestroy() {
        subsciption?.unsubscribe()
    }
}