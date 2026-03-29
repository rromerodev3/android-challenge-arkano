package com.roy.rromeroarkanochallenge.data.remote.datasource

import com.roy.rromeroarkanochallenge.data.remote.dto.CharacterResponseDto

interface RemoteDataSource {
    suspend fun getCharacters(): CharacterResponseDto
}