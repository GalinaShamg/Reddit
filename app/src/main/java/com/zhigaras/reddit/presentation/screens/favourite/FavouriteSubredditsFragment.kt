package com.zhigaras.reddit.presentation.screens.favourite

import androidx.fragment.app.viewModels
import com.zhigaras.reddit.presentation.screens.AbstractSubredditsFragment
import com.zhigaras.reddit.presentation.viewModels.favourite.FavoriteSubredditsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteSubredditsFragment : AbstractSubredditsFragment() {
    
    override val request = ""
    
    override val viewModel: FavoriteSubredditsViewModel by viewModels()
}