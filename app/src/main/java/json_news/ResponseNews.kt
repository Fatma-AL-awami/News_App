package json_news

import com.google.gson.annotations.SerializedName

class ResponseNews {

    @SerializedName("news_details")
    lateinit var news_details: List<news_details>
}