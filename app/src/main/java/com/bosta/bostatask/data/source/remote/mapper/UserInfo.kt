package com.bosta.bostatask.data.source.remote.mapper

import com.bosta.bostatask.data.source.remote.model.UserInfoDto
import com.bosta.bostatask.domain.model.UserInfo

fun UserInfoDto.toUserInfo() = UserInfo(
    address = UserInfo.Address(
        city = address?.city ?: "",
        geo = UserInfo.Address.Geo(
            lat = address?.geo?.lat ?: "",
            lng = address?.geo?.lng ?: ""
        ),
        street = address?.street ?: "",
        suite = address?.suite ?: "",
        zipcode = address?.zipcode ?: ""
    ),
    company = UserInfo.Company(
        bs = company?.bs ?: "",
        catchPhrase = company?.catchPhrase ?: "",
        name = company?.name ?: ""
    ),
    email = email ?: "",
    id = id ?: 0,
    name = name ?: "",
    phone = phone ?: "",
    username = username ?: "",
    website = website ?: ""
)
