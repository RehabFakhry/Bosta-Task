package com.bosta.bostatask.ui.feature.album_details

import com.bosta.bostatask.domain.model.UserAlbumPhoto

data class AlbumDetailsUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val albumPhoto: List<UserAlbumPhotos> = emptyList()
)

data class UserAlbumPhotos(
    val albumId: Int?,
    val id: Int?,
    val thumbnailUrl: String?,
    val title: String?,
)

fun UserAlbumPhoto.toUserAlbumPhoto(): UserAlbumPhotos {
    return UserAlbumPhotos(
        albumId = albumId,
        id = id,
        thumbnailUrl = thumbnailUrl,
        title = title
    )
}