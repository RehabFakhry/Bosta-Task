package com.bosta.bostatask.data.repository

import com.bosta.bostatask.data.source.remote.mapper.toUserAlbumPhoto
import com.bosta.bostatask.data.source.remote.mapper.toUserAlbums
import com.bosta.bostatask.data.source.remote.mapper.toUserInfo
import com.bosta.bostatask.data.source.remote.network.ApiService
import com.bosta.bostatask.domain.model.UserAlbumPhoto
import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo
import com.bosta.bostatask.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BaseRepository(), UserRepository {
    override suspend fun getUserInfo(): List<UserInfo> {
        return wrap { apiService.getUserInfo()}.map{it.toUserInfo()}
    }

    override suspend fun getAllAlbumsForUser(userId: Int): List<UserAlbums> {
        return wrap { apiService.getAllAlbumsForUser(userId) }.map { it.toUserAlbums() }
    }

    override suspend fun getAllPhotosForAlbum(albumId: Int): List<UserAlbumPhoto> {
        return wrap { apiService.getAllPhotosForAlbum(albumId) }.map { it.toUserAlbumPhoto() }
    }
}