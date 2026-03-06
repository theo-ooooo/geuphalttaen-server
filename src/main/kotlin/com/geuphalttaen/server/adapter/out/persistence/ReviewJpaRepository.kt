package com.geuphalttaen.server.adapter.out.persistence

import com.geuphalttaen.server.domain.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ReviewJpaRepository : JpaRepository<Review, Long> {

    fun findByToiletIdOrderByCreatedAtDesc(toiletId: Long): List<Review>

    @Query("SELECT COALESCE(AVG(r.rating), 0.0) FROM Review r WHERE r.toilet.id = :toiletId")
    fun getAverageRating(@Param("toiletId") toiletId: Long): Double
}
