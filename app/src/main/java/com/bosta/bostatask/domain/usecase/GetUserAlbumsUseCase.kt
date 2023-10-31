package com.bosta.bostatask.domain.usecase

import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject
import kotlin.random.Random

class GetUserAlbumsUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<UserAlbums>{
        val randomUserId = Random.nextInt(1, 11)
        return userRepository.getAllAlbumsForUser(randomUserId)?: emptyList()
    }
}