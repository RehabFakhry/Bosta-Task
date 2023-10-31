package com.bosta.bostatask.ui.feature.album_photo

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentViewAlbumImageBinding
import com.bosta.bostatask.ui.base.BaseFragment


class ViewAlbumImageFragment : BaseFragment<FragmentViewAlbumImageBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_view_album_image
    override val viewModel: ViewModel by viewModels()

}