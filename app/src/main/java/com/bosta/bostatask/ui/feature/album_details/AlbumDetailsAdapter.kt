package com.bosta.bostatask.ui.feature.album_details

import com.bosta.bostatask.R
import com.bosta.bostatask.ui.base.BaseAdapter
import com.bosta.bostatask.ui.base.BaseInteractionListener

class AlbumDetailsAdapter(listener: AlbumDetailsInteractionListener)
    : BaseAdapter<AlbumDetailsUiState>(listener) {
    override val layoutId: Int = R.layout.item_album_details
}

interface AlbumDetailsInteractionListener: BaseInteractionListener{
    fun onClickPhoto()
}