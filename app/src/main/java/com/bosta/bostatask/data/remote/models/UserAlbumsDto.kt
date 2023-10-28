package com.bosta.bostatask.data.remote.models


import com.google.gson.annotations.SerializedName

data class UserAlbumsDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)