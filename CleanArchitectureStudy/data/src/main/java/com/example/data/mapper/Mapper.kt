package com.example.data.mapper

import com.example.data.model.example.MovieEntity
import com.example.data.model.rank.RankingEntity
import com.example.domain.model.Movie
import com.example.domain.model.Ranking

/**
 * Data Entity to Data Model
 * Data Layer 에서는 Data Entity 로 받아서 사용하지만, Domain, Presentation Layer 에서는 Data Model 로 사용한다.
 * 즉, Mapper 는 Data Layer 에 존재하면서 다른 계층으로 Data 를 전달할 때, 사용하는 Data Model 에 맞춰서 변환하여 던지는 역할.
 *
 * @param movies Data Model 로 변환 할 Entity
 * @return Data Model
 */
fun mapperToMovie(movies: List<MovieEntity>): List<Movie> {
    return movies.toList().map {
        Movie(
            it.actor,
            it.director,
            it.image,
            it.link,
            it.pubDate,
            it.subtitle,
            it.title,
            it.userRating
        )
    }
}

fun mapperToRanking(ranking: List<RankingEntity>): List<Ranking> {
    return ranking.toList().map {
        Ranking(
            it.id,
            it.index,
            it.fluctuation,
            it.imgUrl,
            it.brandName,
            it.goodsName,
            it.goodsPrice
        )
    }
}