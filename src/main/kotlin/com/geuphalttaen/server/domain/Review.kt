package com.geuphalttaen.server.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "review")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toilet_id", nullable = false)
    val toilet: Toilet,

    @Column(nullable = false)
    val nickname: String,

    @Column(nullable = false)
    val rating: Int, // 1~5

    @Column(nullable = false)
    val cleanliness: Int, // 1~5

    @Column(nullable = false)
    val hasPaper: Boolean,

    @Column(length = 500)
    val comment: String? = null,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
