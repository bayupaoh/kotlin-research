package me.bayupaoh.belajarkotlin.presentation.main

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import me.bayupaoh.belajarkotlin.R
import me.bayupaoh.belajarkotlin.domain.model.NewsItem
import me.bayupaoh.belajarkotlin.BelajarKotlinApplication
import me.bayupaoh.belajarkotlin.domain.network.NewsAPIService
import java.io.IOException
import javax.inject.Inject

class MainActivity: AppCompatActivity(), MainContract, SwipeRefreshLayout.OnRefreshListener{
    @Inject
    lateinit var mNewsPresenter: MainPresenter
    @Inject
    lateinit var mNewsAPI: NewsAPIService


    private val mNewsAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        inject()
        prepareSwipeRefreshLayout()
        prepareRecyclerView()
        recycler_view.adapter = mNewsAdapter
        mNewsPresenter.setNewsAPIInterface(mNewsAPI)
        mNewsPresenter.onViewCreated(this)
        mNewsPresenter.loadNews()
    }

    private fun inject() {
        (application as BelajarKotlinApplication).injector?.inject(this)
    }

    private fun prepareSwipeRefreshLayout() {
        swipe_layout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
        swipe_layout.setOnRefreshListener(this)
    }

    private fun prepareRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.setHasFixedSize(true)
    }

    override fun onNewsItemLoaded(newsItems: List<NewsItem>) {
        swipe_layout.isRefreshing = false
        progress_bar.visibility = View.GONE
        if(newsItems.isEmpty()) {
            status_text_view.setText(R.string.list_is_empty)
            return
        }
        status_text_view.text = null
        mNewsAdapter.setDataSource(newsItems)
    }

    override fun onError(throwable: Throwable?) {
        swipe_layout.isRefreshing = false
        progress_bar.visibility = View.GONE
        if (throwable is IOException) {
            status_text_view.setText(R.string.connection_error)
        } else {
            status_text_view.setText(R.string.list_is_empty)
        }
    }

    override fun hideLoading() {
        swipe_layout.isRefreshing = false
        progress_bar.visibility = View.GONE
    }

    override fun onRefresh() {
        mNewsPresenter.loadNews()
    }

    override fun onStop() {
        super.onStop()
        mNewsPresenter.onDestroy()
    }
}
