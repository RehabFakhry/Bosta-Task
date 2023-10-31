package com.bosta.bostatask.ui.feature.profile

import com.bosta.bostatask.R
import com.bosta.bostatask.ui.base.BaseAdapter
import com.bosta.bostatask.ui.base.BaseInteractionListener

class ProfileAdapter(listener: HomeInteractionListener): BaseAdapter<UserAlbumsUiState>(listener) {
    override val layoutId: Int = R.layout.item_user_album
}

interface HomeInteractionListener: BaseInteractionListener{
    fun onClickAlbum(albumId: Int)
}