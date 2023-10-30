package com.bosta.bostatask.ui.feature.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentHomeBinding
import com.bosta.bostatask.ui.base.BaseFragment
import com.bosta.bostatask.ui.utils.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter: HomeAdapter by lazy { HomeAdapter(viewModel) }


    override fun setup() {
        initiateAdapter()
        collectAction()
    }

    private fun initiateAdapter() {
        binding.recyclerViewAlbums.adapter = homeAdapter
    }

    private fun collectAction(){
       collect(viewModel.effect) { effect ->
           effect.getContentIfHandled()?.let { navigateToAlbumPhotosFragment(it) }
       }
    }

    private fun navigateToAlbumPhotosFragment(id: Int){
        val action = HomeFragmentDirections.actionHomeFragmentToAlbumDetailsFragment(id)
        findNavController().navigate(action)
    }
}