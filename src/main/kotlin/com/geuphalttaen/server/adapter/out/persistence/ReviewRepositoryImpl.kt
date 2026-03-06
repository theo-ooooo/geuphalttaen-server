package com.geuphalttaen.server.adapter.out.persistence

import com.geuphalttaen.server.application.port.out.ReviewRepository
import com.geuphalttaen.server.domain.Review
import org.springframework.stereotype.Repository

@Repository
class ReviewRepositoryImpl(
    private val reviewJpaRepository: ReviewJpaRepository,
) : ReviewRepository {

    override fun save(review: Review): Review {
        return reviewJpaRepository.save(review)
    }

    override fun findByToiletId(toiletId: Long): List<Review> {
        return reviewJpaRepository.findByToiletIdOrderByCreatedAtDesc(toiletId)
    }

    override fun getAverageRating(toiletId: Long): Double {
        return reviewJpaRepository.getAverageRating(toiletId)
    }
}
