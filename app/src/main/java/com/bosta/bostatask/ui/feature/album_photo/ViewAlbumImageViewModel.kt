package com.bosta.bostatask.ui.feature.album_photo

import androidx.lifecycle.SavedStateHandle
import com.bosta.bostatask.domain.usecase.GetUserAlbumPhotoUseCase
import com.bosta.bostatask.ui.base.BaseViewModel
import com.bosta.bostatask.ui.feature.album_details.AlbumDetailsUiState
import com.bosta.bostatask.ui.feature.album_details.UserAlbumPhotos
import com.bosta.bostatask.ui.feature.album_details.toUserAlbumPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class ViewAlbumImageViewModel @Inject constructor(
    private val getUserAlbumPhotoUseCase: GetUserAlbumPhotoUseCase,
    stateHandle: SavedStateHandle
):BaseViewModel<AlbumDetailsUiState, Int>(AlbumDetailsUiState()) {
    override val TAG: String = this::class.java.simpleName

    private val args =
        ViewAlbumImageFragmentArgs.fromSavedStateHandle(stateHandle)

    init {
        getAllPhotosForAlbum()
    }

    private fun getAllPhotosForAlbum() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {getUserAlbumPhotoUseCase(args.id).map { it.toUserAlbumPhoto() }},
            ::onGetUserAlbumPhotosSuccess,
            ::onGetUserAlbumPhotosError
        )
    }

    private fun onGetUserAlbumPhotosSuccess(albumPhotos: List<UserAlbumPhotos>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                albumPhoto = albumPhotos
            )
        }
        getAlbumSingleImage()
        log("data fetched successfully")
    }

    private fun onGetUserAlbumPhotosError(error: Exception) {
        _state.update { it.copy(isLoading = false,isError = true) }
        log("error fetching data")
    }


    private fun getAlbumSingleImage(){
        val albumPhoto = _state.value.albumPhoto.firstOrNull{ it.id == args.id }
        _state.update { it.copy(albumImage = albumPhoto?.thumbnailUrl.toString()) }
    }
}