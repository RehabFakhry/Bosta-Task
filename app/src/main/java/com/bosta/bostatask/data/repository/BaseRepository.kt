package com.bosta.bostatask.data.repository

import android.content.res.Resources.NotFoundException
import android.util.Log
import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <T: Any> wrap(function: suspend() -> Response<T>): T {
        try {
            val response = function()
            if (response.isSuccessful) {
                return response.body() ?: throw NotFoundException()
            } else {
                Log.d("Tag", "Repository failed")
                when (response.code()) {
                    404 -> throw NotFoundException()
                    else -> throw Exception(response.toString())
                }
            }
        } catch (e: Exception){
            Log.d("TAG", "Response failed: ${e.message}")
            throw NotFoundException()
        }
    }
}