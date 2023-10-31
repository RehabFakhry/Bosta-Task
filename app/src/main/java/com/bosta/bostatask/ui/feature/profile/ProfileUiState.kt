package com.bosta.bostatask.ui.feature.profile

import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo


data class HomeUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val user: UserInfoUiState = UserInfoUiState(),
    val userAlbums: List<UserAlbumsUiState> = emptyList()
)

data class UserInfoUiState(
    val id: Int? = 0,
    val name: String? = "",
    val address: String = "",
    )

data class UserAlbumsUiState(
    val id: Int? = 0,
    val title: String? = "",
    val userId: Int? = 0
)

fun UserInfo.toUserInfoUiState(): UserInfoUiState {
    val addressLine = listOf(address?.street, address?.suite, address?.city, address?.zipcode)
        .filterNotNull()
        .joinToString(", ")

    return UserInfoUiState(
        id = id,
        name = name,
        address = addressLine
    )
}

fun UserAlbums.toUserAlbumsUiState(): UserAlbumsUiState {
    return UserAlbumsUiState(
        id = id,
        title = title,
        userId = userId
    )
}