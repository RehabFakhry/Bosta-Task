package com.bosta.bostatask.data.source.remote.mapper

import com.bosta.bostatask.data.source.remote.model.UserAlbumsDto
import com.bosta.bostatask.domain.model.UserAlbums

fun UserAlbumsDto.toUserAlbums() = UserAlbums(
    id = id?: 0,
    title = title?: "",
    userId = userId?: 0
)