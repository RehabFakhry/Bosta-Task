package com.bosta.bostatask.domain.usecase

import com.bosta.bostatask.domain.model.UserInfo
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(userId: Int): List<UserInfo> {
        return userRepository.getUserInfo(userId)?: emptyList()
    }
}