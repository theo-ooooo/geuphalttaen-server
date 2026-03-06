package com.geuphalttaen.server.adapter.`in`.web.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ReviewRequest(
    @field:NotBlank
    @field:Size(max = 20)
    val nickname: String,

    @field:Min(1)
    @field:Max(5)
    val rating: Int,

    @field:Min(1)
    @field:Max(5)
    val cleanliness: Int,

    val hasPaper: Boolean,

    @field:Size(max = 500)
    val comment: String? = null,
)
