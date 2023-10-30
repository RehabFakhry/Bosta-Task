package com.bosta.bostatask.domain.repository

import com.bosta.bostatask.domain.model.UserAlbumPhoto
import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo

interface UserRepository {

    suspend fun getUserInfo(userId: Int): List<UserInfo>?

    suspend fun getAllAlbumsForUser(userId: Int): List<UserAlbums>?

    suspend fun getAllPhotosForAlbum(albumId: Int): List<UserAlbumPhoto>?
}