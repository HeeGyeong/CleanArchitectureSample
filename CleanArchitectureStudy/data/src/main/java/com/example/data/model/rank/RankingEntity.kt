package com.example.data.model.rank

import com.example.data.model.CommonModel
import com.google.gson.annotations.SerializedName

class RankingEntity {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("index")
    var index: Int? = 0

    @SerializedName("fluctuation")
    var fluctuation: Int? = 0

    @SerializedName("imgUrl")
    var imgUrl: String? = null

    @SerializedName("brandName")
    var brandName: String? = null

    @SerializedName("goodsName")
    var goodsName: String? = null

    @SerializedName("goodsPrice")
    var goodsPrice: String? = null

}