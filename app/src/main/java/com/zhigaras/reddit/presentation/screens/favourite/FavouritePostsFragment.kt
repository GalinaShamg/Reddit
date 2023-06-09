package com.zhigaras.reddit.presentation.screens.favourite

import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.zhigaras.reddit.R
import com.zhigaras.reddit.presentation.screens.AbstractPostsFragment
import com.zhigaras.reddit.presentation.viewModels.favourite.FavoritePostsViewModel

class FavouritePostsFragment : AbstractPostsFragment() {
    
    override val viewModel: FavoritePostsViewModel by viewModels()
    override val apiQuery = ""
    
    override fun setUpPageAdapter() {
        val divider = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        divider.setDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.item_divider)!!)
        binding.recyclerView.apply {
            adapter = postsPageAdapter
            addItemDecoration(divider)
        }
    }
    
    override fun observeSubredditUpdates(currentSubredditId: String) = Unit
    
    override fun observeSubscribeResult() = Unit
    
}