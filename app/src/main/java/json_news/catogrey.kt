package json_news

import com.google.gson.annotations.SerializedName

data class category (
@SerializedName("title") var title :String ="",
@SerializedName("sub_title") var sub_title :String="",
@SerializedName("id") var id: Int = 0
)

data class news_details
    (

    @SerializedName("id") var ID : Int,
    @SerializedName("title") var title : String,
    @SerializedName("image") var image : Long,
    @SerializedName("details") var details : String,
@SerializedName("id_category") var id_category : Int)
