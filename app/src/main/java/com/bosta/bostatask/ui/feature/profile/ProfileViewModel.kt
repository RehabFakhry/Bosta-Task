package com.bosta.bostatask.ui.feature.profile

import androidx.lifecycle.viewModelScope
import com.bosta.bostatask.domain.usecase.GetUserAlbumsUseCase
import com.bosta.bostatask.domain.usecase.GetUserInfoUseCase
import com.bosta.bostatask.ui.base.BaseViewModel
import com.bosta.bostatask.ui.utils.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserAlbumsUseCase: GetUserAlbumsUseCase
): BaseViewModel<HomeUiState, Int>(HomeUiState()), HomeInteractionListener {

    override val TAG: String = this::class.java.simpleName

    init {
        getUserInfo()
        getUserAlbums()
    }

    private fun getUserInfo() {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { getUserInfoUseCase().map { it.toUserInfoUiState() }},
                ::onGeUserInfoSuccess,
                ::onGetUserInfoError,
            )
    }

    private fun getUserAlbums() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getUserAlbumsUseCase().map { it.toUserAlbumsUiState() } },
            ::onGetUserAlbumsSuccess,
            ::onGetUserAlbumsError
        )
    }

    private fun onGeUserInfoSuccess(userInfo: List<UserInfoUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                user = userInfo.firstOrNull()!!,
            )
        }
        log("data fetched successfully: ${state.value.user}")
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
        viewModelScope.launch { _effect.emit(EventHandler(albumId)) }
    }
}