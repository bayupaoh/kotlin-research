package me.bayupaoh.belajarkotlin.domain.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import me.bayupaoh.belajarkotlin.domain.model.NewsItem;
import me.bayupaoh.belajarkotlin.domain.model.Pagination;

/**
 * Created by King Oil on 12/10/2017.
 */

public class NewsResponse {
    @SerializedName("Pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("NewsItem")
    @Expose
    private List<NewsItem> newsItem = new ArrayList<NewsItem>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<NewsItem> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }
}
