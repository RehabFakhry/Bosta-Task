package com.bosta.bostatask.ui.feature.home

import androidx.fragment.app.viewModels
import com.bosta.bostatask.R
import com.bosta.bostatask.databinding.FragmentHomeBinding
import com.bosta.bostatask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter: HomeAdapter by lazy { HomeAdapter(viewModel) }

    override fun setup() {
        initiateAdapter()
    }

    private fun initiateAdapter() {
        binding.recyclerViewAlbums.adapter = homeAdapter
    }
}