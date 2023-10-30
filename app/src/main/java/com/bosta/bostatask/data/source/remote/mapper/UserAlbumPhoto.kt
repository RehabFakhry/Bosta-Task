package com.bosta.bostatask.data.source.remote.mapper

import com.bosta.bostatask.data.source.remote.model.UserAlbumPhotoDto
import com.bosta.bostatask.domain.model.UserAlbumPhoto

fun UserAlbumPhotoDto.toUserAlbumPhoto() = UserAlbumPhoto(
    albumId = albumId?: 0,
    id = id?: 0,
    thumbnailUrl = thumbnailUrl?: "",
    title = title?: "",
)