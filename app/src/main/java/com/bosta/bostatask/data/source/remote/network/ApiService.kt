package com.bosta.bostatask.data.source.remote.network

import com.bosta.bostatask.data.source.remote.model.UserAlbumPhotoDto
import com.bosta.bostatask.data.source.remote.model.UserAlbumsDto
import com.bosta.bostatask.data.source.remote.model.UserInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUserInfo(): Response<List<UserInfoDto>>

    @GET("albums")
    suspend fun getAllAlbumsForUser(@Query("userId") userId: Int): Response<List<UserAlbumsDto>>

    @GET("photos")
    suspend fun getAllPhotosForAlbum(@Query("albumId") albumId: Int): Response<List<UserAlbumPhotoDto>>

}