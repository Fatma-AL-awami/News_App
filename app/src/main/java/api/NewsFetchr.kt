package api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import json_news.ResponseNews
import json_news.news_details
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFetchr {

    private var newsapi: news_api

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://192.168.1.1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsapi = retrofit.create(news_api::class.java)
    }

    fun fitch(): LiveData<List<news_details>> {
        val responseLiveData: MutableLiveData<List<news_details>> = MutableLiveData()
        val quakeRequest: Call<ResponseNews> =   newsapi.fitchdata()
        quakeRequest.enqueue(object : Callback<ResponseNews> {
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.e("Failure", "Failed to fetch ", t)
            }

            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>
            ) {
                Log.e("sucess to fetch", response.code().toString())
                val quakerResponse:ResponseNews? = response.body()
                var featuresList: List<news_details> = quakerResponse?.news_details
                    ?: mutableListOf()

                responseLiveData.value = featuresList
            }
        })
        return responseLiveData
    }



}