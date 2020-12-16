package com.example.news_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import api.NewsFetchr
import json_news.news_details

class NewsViewModel: ViewModel() {
    val quakesLiveData: LiveData<List<news_details>> = NewsFetchr().fitch()

}