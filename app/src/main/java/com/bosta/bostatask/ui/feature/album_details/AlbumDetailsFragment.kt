package com.bosta.bostatask.ui.feature.album_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentAlbumDetailsBinding
import com.bosta.bostatask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumDetailsFragment : BaseFragment<FragmentAlbumDetailsBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_album_details
    override val viewModel: AlbumDetailsViewModel by viewModels()
    private val albumDetailsAdapter: AlbumDetailsAdapter by lazy { AlbumDetailsAdapter(viewModel) }

    override fun setup() {
        initiateAdapter()
    }

    private fun initiateAdapter() {
        binding.recyclerViewAlbumPhotos.adapter = albumDetailsAdapter
    }

}