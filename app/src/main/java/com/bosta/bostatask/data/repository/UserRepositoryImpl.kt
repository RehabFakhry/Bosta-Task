package com.bosta.bostatask.data.repository

import com.bosta.bostatask.data.remote.network.ApiService
import com.bosta.bostatask.domain.model.UserAlbumPhoto
import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BaseRepository(), UserRepository {
    override suspend fun getAllUsers(): List<UserInfo>? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAlbumsForUser(userId: Int): List<UserAlbums>? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPhotosForAlbum(albumId: Int): List<UserAlbumPhoto>? {
        TODO("Not yet implemented")
    }
}