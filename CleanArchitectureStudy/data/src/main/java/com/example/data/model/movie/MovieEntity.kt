package com.example.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Movie Data Class
 * Response 에서 받아온 Data 중 Object 인 경우 해당 Entity 를 선언하여 데이터를 받는다.
 * MovieEntity data class 는 MovieResponse 에서 items 로 가져온 movies 데이터를 movie 라는 table 을 생성 후 해당 테이블에 저장시킨다.
 *
 * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
 *          즉, MovieEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
 *          DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
 * DTO : 변경이 쉽게 가능한 Data Class.
 *        데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
 *        데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
 */
@Entity(tableName = "movie")
data class MovieEntity(
    @SerializedName("actor")
    val actor: String,

    @SerializedName("director")
    val director: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("pubDate")
    val pubDate: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("title")
    val title: String,

    @SerializedName("userRating")
    val userRating: String
)