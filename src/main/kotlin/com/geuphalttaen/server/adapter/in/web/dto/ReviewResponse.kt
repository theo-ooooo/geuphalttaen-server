package com.geuphalttaen.server.adapter.`in`.web.dto

import com.geuphalttaen.server.domain.Review
import java.time.LocalDateTime

data class ReviewResponse(
    val id: Long,
    val nickname: String,
    val rating: Int,
    val cleanliness: Int,
    val hasPaper: Boolean,
    val comment: String?,
    val createdAt: LocalDateTime,
) {
    companion object {
        fun from(review: Review) = ReviewResponse(
            id = review.id,
            nickname = review.nickname,
            rating = review.rating,
            cleanliness = review.cleanliness,
            hasPaper = review.hasPaper,
            comment = review.comment,
            createdAt = review.createdAt,
        )
    }
}
