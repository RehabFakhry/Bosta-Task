package com.bosta.bostatask.domain.usecase

import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class GetUserAlbumsUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: Int): List<UserAlbums>{
        return userRepository.getAllAlbumsForUser(userId)?: emptyList()
    }
}