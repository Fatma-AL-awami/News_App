package api

import json_news.ResponseNews
import json_news.news_details
import retrofit2.Call
import retrofit2.http.GET

interface news_api {

    @GET("/coding_news/api/new_api.php")

    fun fitchdata(): Call<ResponseNews>
}