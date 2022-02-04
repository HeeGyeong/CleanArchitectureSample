package com.example.data.model

import com.google.gson.annotations.SerializedName

class CommonModel {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("imgUrl")
    var imgUrl: String? = null

    @SerializedName("cname")
    var cname: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("sub")
    var sub: String? = null

    @SerializedName("goodsName")
    var goodsName: String? = null

    @SerializedName("goodsPrice")
    var goodsPrice: String? = null

    @SerializedName("brandName")
    var brandName: String? = null

    @SerializedName("keywordType")
    var keywordType: String? = null

    @SerializedName("index")
    var index: Int? = 0

    @SerializedName("fluctuation")
    var fluctuation: Int? = 0

    @SerializedName("hasNewProduct")
    var hasNewProduct: Boolean = false

    @SerializedName("isPriceChange")
    var isPriceChange: Boolean = false

    @SerializedName("groupId")
    var groupId: String? = null

    @SerializedName("isWish")
    var isWish: Boolean = false

    @SerializedName("rate")
    var rate: String? = null

    var isSelected: Boolean = false

    var isChecked: Boolean = false

    @SerializedName("goodsList")
    var goodsList: ArrayList<CommonModel>? = null

    @SerializedName("snsCnt")
    var snsCnt: String? = null

    @SerializedName("type")
    var type: String? = "false"

    @SerializedName("lprice")
    var lprice: String? = null

    @SerializedName("hprice")
    var hprice: String? = null

    @SerializedName("productKind")
    var productKind: Int? = 0

    @SerializedName("rateRegdate")
    var rateRegdate: String? = null

    @SerializedName("link")
    var link: String? = null

    @SerializedName("layoutType")
    var layoutType: String? = null
}