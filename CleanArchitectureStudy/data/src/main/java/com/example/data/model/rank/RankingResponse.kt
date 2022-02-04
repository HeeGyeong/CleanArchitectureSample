package com.example.data.model.rank

import com.example.data.model.CommonModel
import com.google.gson.annotations.SerializedName

class RankingResponse {

    @SerializedName("totalCnt")
    var totalCnt: Int = 0

    @SerializedName("updateDate")
    var updateDate: String? = null

    @SerializedName("rcCode")
    var rcCode: String? = null

    @SerializedName("goodsList")
    var goodsList: List<RankingEntity>? = null
}