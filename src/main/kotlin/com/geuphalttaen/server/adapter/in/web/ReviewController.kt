package com.geuphalttaen.server.adapter.`in`.web

import com.geuphalttaen.server.adapter.`in`.web.dto.ReviewRequest
import com.geuphalttaen.server.adapter.`in`.web.dto.ReviewResponse
import com.geuphalttaen.server.application.port.`in`.ReviewUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/toilets/{toiletId}/reviews")
class ReviewController(
    private val reviewUseCase: ReviewUseCase,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createReview(
        @PathVariable toiletId: Long,
        @Valid @RequestBody request: ReviewRequest,
    ): ReviewResponse {
        return ReviewResponse.from(reviewUseCase.createReview(toiletId, request))
    }

    @GetMapping
    fun getReviews(@PathVariable toiletId: Long): List<ReviewResponse> {
        return reviewUseCase.getReviews(toiletId).map { ReviewResponse.from(it) }
    }

    @GetMapping("/rating")
    fun getAverageRating(@PathVariable toiletId: Long): Map<String, Double> {
        return mapOf("averageRating" to reviewUseCase.getAverageRating(toiletId))
    }
}
