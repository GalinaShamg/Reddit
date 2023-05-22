package com.zhigaras.reddit.presentation.screens.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.zhigaras.reddit.R
import com.zhigaras.reddit.databinding.FragmentFavoriteBinding
import com.zhigaras.reddit.presentation.screens.CommonAbstractFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : CommonAbstractFragment() {
    
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        val pageAdapter = FavouriteViewPagerAdapter(this)
    
        val viewPager = binding.favouritePager
        viewPager.adapter = pageAdapter
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.subreddits)
                1 -> tab.text = getString(R.string.posts)
            }
        }.attach()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}