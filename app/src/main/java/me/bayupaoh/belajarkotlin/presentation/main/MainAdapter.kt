package me.bayupaoh.belajarkotlin.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import me.bayupaoh.belajarkotlin.R
import me.bayupaoh.belajarkotlin.domain.model.NewsItem
import me.bayupaoh.belajarkotlin.util.Shortcuts

/**
 * Created by King Oil on 12/10/2017.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.NewsViewHolder>() {

    private var mDataSource: List<NewsItem>? = null

    fun setDataSource(dataSource: List<NewsItem>) {
        this.mDataSource = dataSource
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
        holder?.bind(mDataSource!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataSource?.size ?: 0
    }

    class NewsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsItem: NewsItem? = null

        private val mImageView: ImageView? by lazy {
            itemView.findViewById(R.id.image_view) as ImageView
        }

        private val mHeadlineTextView: TextView? by lazy {
            itemView.findViewById(R.id.headLineTextView) as TextView
        }

        private val mAgencyTextView: TextView? by lazy {
            itemView.findViewById(R.id.agencyTextView) as TextView
        }

        private val mDateTextView: TextView? by lazy {
            itemView.findViewById(R.id.dateTextView) as TextView?
        }
        private val mCaptionTextView: TextView? by lazy {
            itemView.findViewById(R.id.captionTextView) as TextView?
        }

        fun bind(newsItem: NewsItem) {
            this.newsItem = newsItem
            mHeadlineTextView!!.text = newsItem.headLine

            if (newsItem.agency == null)
                mAgencyTextView!!.visibility = View.GONE
            else
                mAgencyTextView!!.text = itemView.resources.getString(
                        R.string.view_news_item_agency,
                        newsItem.agency)

            mDateTextView!!.text = Shortcuts.formatDate(newsItem.dateLine!!)

            mCaptionTextView!!.text = newsItem.caption

            Glide.with(itemView.context).load(newsItem.image?.thumb).into(mImageView)
        }


    }
}