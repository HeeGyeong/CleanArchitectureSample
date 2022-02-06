package com.example.domain.model

/**
 * 실제 사용하는 Data Class.
 *
 * MovieEntity 와 동일한 데이터 모델이지만, 필요에 따라 필요한 데이터만 선언하여 사용하면 된다.
 */
data class Movie(
    val actor: String,
    val director: String,
    val image: String,
    val link: String,
    val pubDate: String,
    val subtitle: String,
    val title: String,
    val userRating: String
)