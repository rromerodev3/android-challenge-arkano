package com.roy.rromeroarkanochallenge.domain.model

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val status: CharacterStatus
)

enum class CharacterStatus {
    ALIVE, DEATH, UNKNOWN
}
