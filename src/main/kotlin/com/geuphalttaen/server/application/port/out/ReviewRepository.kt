package com.geuphalttaen.server.application.port.out

import com.geuphalttaen.server.domain.Review

interface ReviewRepository {
    fun save(review: Review): Review
    fun findByToiletId(toiletId: Long): List<Review>
    fun getAverageRating(toiletId: Long): Double
}
