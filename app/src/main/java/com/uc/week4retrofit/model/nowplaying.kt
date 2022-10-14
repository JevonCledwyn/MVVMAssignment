package com.uc.week4retrofit.model

data class nowplaying(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)