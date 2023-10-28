package com.bosta.bostatask.data.remote.mapper

import com.bosta.bostatask.data.remote.model.UserInfoDto
import com.bosta.bostatask.domain.model.UserInfo

fun UserInfoDto.toUserInfo() = UserInfo(
    address = UserInfo.Address(
        city = address?.city?: "",
        street = address?.street?: "",
        suite = address?.suite?: "",
        zipcode = address?.zipcode?: ""
    ),
    id = id?: 0,
    name = name?: "",

)