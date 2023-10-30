package com.bosta.bostatask.ui.feature.home

import com.bosta.bostatask.domain.usecase.GetUserAlbumsUseCase
import com.bosta.bostatask.domain.usecase.GetUserInfoUseCase
import com.bosta.bostatask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserAlbumsUseCase: GetUserAlbumsUseCase
): BaseViewModel<HomeUiState, Long>(HomeUiState()), HomeInteractionListener {

    override val TAG: String = this::class.java.simpleName

    init {
        getUserInfo()
        getUserAlbums()
    }

    private fun getUserInfo() {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { getUserInfoUseCase(1).map { it.toUserInfoUiState() }},
                ::onGeUserInfoSuccess,
                ::onGetUserInfoError,
            )
    }

    private fun getUserAlbums() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getUserAlbumsUseCase(1).map { it.toUserAlbumsUiState() } },
            ::onGetUserAlbumsSuccess,
            ::onGetUserAlbumsError
        )
    }

    private fun onGeUserInfoSuccess(userInfo: List<UserInfoUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                userInfo = userInfo
            )
        }
        log("data fetched successfully")
    }

    private fun onGetUserInfoError(exception: Exception) {
        _state.update { it.copy(isLoading = false, isError = true) }
        log("error fetching data")
    }


    private fun onGetUserAlbumsSuccess(userAlbums: List<UserAlbumsUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                userAlbums = userAlbums
            )
        }
    }

    private fun onGetUserAlbumsError(error: Exception) =
        _state.update { it.copy(isLoading = false, isError = true) }


    override fun onClickAlbum(albumId: Int) {
        TODO("Not yet implemented")
    }
}