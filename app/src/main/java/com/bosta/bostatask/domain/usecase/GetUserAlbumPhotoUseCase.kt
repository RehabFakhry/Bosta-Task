package com.bosta.bostatask.domain.usecase

import com.bosta.bostatask.domain.model.UserAlbumPhoto
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class GetUserAlbumPhotoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(albumId: Int): List<UserAlbumPhoto> =
        userRepository.getAllPhotosForAlbum(albumId)?: emptyList()
}