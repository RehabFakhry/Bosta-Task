package com.bosta.bostatask.ui.feature.profile

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentProfileBinding
import com.bosta.bostatask.ui.base.BaseFragment
import com.bosta.bostatask.ui.utils.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()
    private val profileAdapter: ProfileAdapter by lazy { ProfileAdapter(viewModel) }


    override fun setup() {
        initiateAdapter()
        collectAction()
    }

    private fun initiateAdapter() {
        binding.recyclerViewAlbums.adapter = profileAdapter
    }

    private fun collectAction(){
       collect(viewModel.effect) { effect ->
           effect.getContentIfHandled()?.let { navigateToAlbumPhotosFragment(it) }
       }
    }

    private fun navigateToAlbumPhotosFragment(id: Int){
        val action = ProfileFragmentDirections.actionProfileFragmentToAlbumDetailsFragment(id)
        findNavController().navigate(action)
    }
}