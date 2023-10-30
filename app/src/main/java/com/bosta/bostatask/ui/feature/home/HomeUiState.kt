package com.bosta.bostatask.ui.feature.home

import com.bosta.bostatask.domain.model.UserAlbums
import com.bosta.bostatask.domain.model.UserInfo


data class HomeUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val userInfo: List<UserInfoUiState> = emptyList(),
    val userAlbums: List<UserAlbumsUiState> = emptyList()
)

data class UserInfoUiState(
    val address: UserAddress = UserAddress(),
    val id: Int? = 0,
    val name: String? = ""
)

data class UserAddress(
    val city: String? = "",
    val street: String? = "",
    val suite: String? = "",
    val zipcode: String? = ""
)

data class UserAlbumsUiState(
    val id: Int? = 0,
    val title: String? = "",
    val userId: Int? = 0
)

fun UserInfo.toUserInfoUiState(): UserInfoUiState {
 return UserInfoUiState(
     address = UserAddress(
         city = address?.city,
         street = address?.street,
         suite = address?.suite,
         zipcode = address?.zipcode
     ),
     id = id,
     name = name
 )
}

fun UserAlbums.toUserAlbumsUiState(): UserAlbumsUiState {
    return UserAlbumsUiState(
        id = id,
        title = title,
        userId = userId
    )
}