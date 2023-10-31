package com.bosta.bostatask.domain.usecase

import com.bosta.bostatask.domain.model.UserInfo
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject
import kotlin.random.Random

class GetUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): List<UserInfo> {
        val randomUserId = Random.nextInt(1, 11)
        return userRepository.getUserInfo(randomUserId)?: emptyList()
    }
}