package com.roy.rromeroarkanochallenge.data.repository

import com.roy.rromeroarkanochallenge.data.remote.datasource.RemoteDataSource
import com.roy.rromeroarkanochallenge.data.remote.dto.toDomain
import com.roy.rromeroarkanochallenge.domain.model.Character
import com.roy.rromeroarkanochallenge.domain.repository.CharacterRepository
import javax.inject.Inject
import kotlin.collections.map

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return remoteDataSource.getCharacters()
            .results
            .map { it.toDomain() }
    }
}