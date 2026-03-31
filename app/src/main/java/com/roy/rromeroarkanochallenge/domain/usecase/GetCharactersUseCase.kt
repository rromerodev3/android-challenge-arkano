package com.roy.rromeroarkanochallenge.domain.usecase

import com.roy.rromeroarkanochallenge.domain.model.Character
import com.roy.rromeroarkanochallenge.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Result<List<Character>> {
        return repository.getCharacters()
    }
}