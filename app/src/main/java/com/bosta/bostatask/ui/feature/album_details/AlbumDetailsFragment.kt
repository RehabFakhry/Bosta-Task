package com.bosta.bostatask.ui.feature.album_details

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentAlbumDetailsBinding
import com.bosta.bostatask.ui.base.BaseFragment
import com.bosta.bostatask.ui.utils.collect
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumDetailsFragment : BaseFragment<FragmentAlbumDetailsBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_album_details
    override val viewModel: AlbumDetailsViewModel by viewModels()
    private val albumDetailsAdapter: AlbumDetailsAdapter by lazy { AlbumDetailsAdapter(viewModel) }

    override fun setup() {
        initiateAdapter()
        searchOnImage()
        collectAction()
    }

    private fun initiateAdapter() {
        binding.recyclerViewAlbumPhotos.adapter = albumDetailsAdapter
    }

    private fun searchOnImage() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchPhotos(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchPhotos(newText.orEmpty())
                return true
            }
        })
    }

    private fun collectAction() {
        collect(viewModel.effect) { effect ->
            effect.getContentIfHandled()?.let { navigateToViewAlbumImageFragment(it) }
        }
    }

    private fun navigateToViewAlbumImageFragment(imageId: Int) {
        val action = AlbumDetailsFragmentDirections
            .actionAlbumDetailsFragmentToViewPhotoFragment(imageId)
        findNavController().navigate(action)
    }
}