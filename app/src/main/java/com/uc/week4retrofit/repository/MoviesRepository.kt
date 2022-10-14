package com.uc.week4retrofit.repository

import com.uc.week4retrofit.retrofit.EndPointAPI
import org.intellij.lang.annotations.Language
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: EndPointAPI) {
    suspend fun getNowPlayingData(apiKey: String, language: String, page: Int) = api.getNowPlaying(apiKey, language, page)


    suspend fun getMovieDetailResults(apiKey: String, id: Int) = api.getMovieDetails(id, apiKey)
}