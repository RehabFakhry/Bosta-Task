package com.bosta.bostatask.data.remote.network

import com.bosta.bostatask.data.remote.models.UserAlbumPhotoDto
import com.bosta.bostatask.data.remote.models.UserAlbumsDto
import com.bosta.bostatask.data.remote.models.UserInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getAllUsers(): Response<UserInfoDto>

    @GET("albums")
    suspend fun getAllAlbumsForUser(@Query("userId") userId: Int): Response<UserAlbumsDto>

    @GET("photos")
    suspend fun getAllPhotosForAlbum(@Query("albumId") albumId: Int): Response<UserAlbumPhotoDto>

}