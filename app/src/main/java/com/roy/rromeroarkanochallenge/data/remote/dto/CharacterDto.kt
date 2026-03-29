package com.roy.rromeroarkanochallenge.data.remote.dto

import com.roy.rromeroarkanochallenge.domain.model.Character
import com.roy.rromeroarkanochallenge.domain.model.CharacterStatus

data class CharacterDto(
    val id: Int,
    val name: String,
    val image: String,
    val status: String
)

fun CharacterDto.toDomain() = Character(
    id = id,
    name = name,
    imageUrl = image,
    status = when (status) {
        "Alive" -> CharacterStatus.ALIVE
        "Dead" -> CharacterStatus.DEATH
        else -> CharacterStatus.UNKNOWN
    }
)
