package com.geuphalttaen.server.application.port.`in`

import com.geuphalttaen.server.adapter.`in`.web.dto.ReviewRequest
import com.geuphalttaen.server.domain.Review

interface ReviewUseCase {
    fun createReview(toiletId: Long, request: ReviewRequest): Review
    fun getReviews(toiletId: Long): List<Review>
    fun getAverageRating(toiletId: Long): Double
}
