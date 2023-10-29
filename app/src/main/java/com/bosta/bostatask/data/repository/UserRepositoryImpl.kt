package com.bosta.bostatask.data.repository

import com.bosta.bostatask.data.remote.mapper.toUserAlbumPhoto
import com.bosta.bostatask.data.remote.mapper.toUserAlbums
import com.bosta.bostatask.data.remote.mapper.toUserInfo
import com.bosta.bostatask.data.remote.network.ApiService
import com.bosta.bostatask.domain.model.UserAlbumPhoto
import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BaseRepository(), UserRepository {
    override suspend fun getAllUsers(): List<UserInfo> {
        return (listOf(wrap { apiService.getAllUsers() } .toUserInfo()))
    }

    override suspend fun getAllAlbumsForUser(userId: Int): List<UserAlbums> {
        return (listOf(wrap { apiService.getAllAlbumsForUser(userId) }.toUserAlbums()))
    }

    override suspend fun getAllPhotosForAlbum(albumId: Int): List<UserAlbumPhoto> {
        return (listOf(wrap { apiService.getAllPhotosForAlbum(albumId) }.toUserAlbumPhoto()))
    }
}