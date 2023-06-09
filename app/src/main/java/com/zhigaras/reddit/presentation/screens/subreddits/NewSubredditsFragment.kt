package com.zhigaras.reddit.presentation.screens.subreddits

import androidx.fragment.app.viewModels
import com.zhigaras.reddit.presentation.screens.AbstractSubredditsFragment
import com.zhigaras.reddit.presentation.viewModels.subreddits.NewSubredditsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewSubredditsFragment : AbstractSubredditsFragment() {
    
    override val request = "new"
    
    override val viewModel: NewSubredditsViewModel by viewModels()
    
}