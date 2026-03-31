package com.roy.rromeroarkanochallenge.domain.repository

import com.roy.rromeroarkanochallenge.domain.model.Character


interface CharacterRepository {
    suspend fun getCharacters(): Result<List<Character>>
}