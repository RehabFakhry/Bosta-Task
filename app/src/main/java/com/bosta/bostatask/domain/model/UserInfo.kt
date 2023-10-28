package com.bosta.bostatask.domain.model

data class UserInfo(
    val address: Address?,
    val id: Int?,
    val name: String?,
) {
    data class Address(
        val city: String?,
        val street: String?,
        val suite: String?,
        val zipcode: String?
    )
}
