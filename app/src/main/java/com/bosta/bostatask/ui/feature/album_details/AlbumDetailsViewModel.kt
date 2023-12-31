package com.bosta.bostatask.ui.feature.album_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.bosta.bostatask.domain.usecase.GetUserAlbumPhotoUseCase
import com.bosta.bostatask.ui.base.BaseViewModel
import com.bosta.bostatask.ui.utils.EventHandler
import com.bumptech.glide.Glide.init
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumDetailsViewModel @Inject constructor(
    private val getUserAlbumPhotoUseCase: GetUserAlbumPhotoUseCase,
    savedStateHandle: SavedStateHandle,
    ): BaseViewModel<AlbumDetailsUiState, Int>(AlbumDetailsUiState()),AlbumDetailsInteractionListener {

    override val TAG: String = this::class.java.simpleName

    private val args = AlbumDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle)

    private var searchResultsFound: Boolean = true


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

    fun searchPhotos(query: String) {
        val filteredPhotos = _state.value.albumPhoto.filter { photo ->
            photo.title?.contains(query, ignoreCase = true) == true
        }
        searchResultsFound = filteredPhotos.isNotEmpty()
        _state.update { it.copy(albumPhoto = filteredPhotos) }
    }

    fun isSearchResultsFound(): Boolean {
        return searchResultsFound
    }

    private fun onGetUserAlbumPhotosSuccess(albumPhotos: List<UserAlbumPhotos>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                albumPhoto = albumPhotos
            )
        }
        log("data fetched successfully")
    }

    private fun onGetUserAlbumPhotosError(error: Exception) {
        _state.update { it.copy(isLoading = false,isError = true) }
        log("error fetching data")
    }

    override fun onClickAlbumImage(imageId: Int) {
        viewModelScope.launch { _effect.emit(EventHandler(imageId)) }
    }
}