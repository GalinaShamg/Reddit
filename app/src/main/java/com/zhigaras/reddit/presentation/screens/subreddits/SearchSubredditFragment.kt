package com.zhigaras.reddit.presentation.screens.subreddits

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.zhigaras.reddit.presentation.screens.AbstractSubredditsFragment
import com.zhigaras.reddit.presentation.viewModels.subreddits.SearchSubredditViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchSubredditFragment : AbstractSubredditsFragment() {
    
    override var request = ""
    
    override val viewModel: SearchSubredditViewModel by viewModels()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        request = arguments?.getString("searchQuery") ?: ""
        super.onViewCreated(view, savedInstanceState)
        
    }
}