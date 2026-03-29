package com.roy.rromeroarkanochallenge.data.remote.datasource

import com.roy.rromeroarkanochallenge.data.remote.api.RickAndMortyApi
import com.roy.rromeroarkanochallenge.data.remote.dto.CharacterResponseDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: RickAndMortyApi
): RemoteDataSource {
    override suspend fun getCharacters(): CharacterResponseDto {
        return api.characters()
    }
}