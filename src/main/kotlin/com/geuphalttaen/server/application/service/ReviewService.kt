package com.geuphalttaen.server.application.service

import com.geuphalttaen.server.adapter.`in`.web.dto.ReviewRequest
import com.geuphalttaen.server.application.port.`in`.ReviewUseCase
import com.geuphalttaen.server.application.port.out.ReviewRepository
import com.geuphalttaen.server.application.port.out.ToiletRepository
import com.geuphalttaen.server.common.exception.NotFoundException
import com.geuphalttaen.server.domain.Review
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val toiletRepository: ToiletRepository,
) : ReviewUseCase {

    @Transactional
    override fun createReview(toiletId: Long, request: ReviewRequest): Review {
        val toilet = toiletRepository.findById(toiletId)
            ?: throw NotFoundException("화장실 정보를 찾을 수 없습니다.")

        val review = Review(
            toilet = toilet,
            nickname = request.nickname,
            rating = request.rating,
            cleanliness = request.cleanliness,
            hasPaper = request.hasPaper,
            comment = request.comment,
        )
        return reviewRepository.save(review)
    }

    override fun getReviews(toiletId: Long): List<Review> {
        return reviewRepository.findByToiletId(toiletId)
    }

    override fun getAverageRating(toiletId: Long): Double {
        return reviewRepository.getAverageRating(toiletId)
    }
}
