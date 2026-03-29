package com.roy.rromeroarkanochallenge.data.remote.api

import com.roy.rromeroarkanochallenge.data.remote.dto.CharacterResponseDto
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun characters(): CharacterResponseDto
}