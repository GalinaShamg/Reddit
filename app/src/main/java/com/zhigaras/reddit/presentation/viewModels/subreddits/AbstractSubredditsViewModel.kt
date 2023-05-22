package com.zhigaras.reddit.presentation.viewModels.subreddits

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.zhigaras.reddit.data.MainRepository
import com.zhigaras.reddit.di.IoDispatcher
import com.zhigaras.reddit.domain.model.SubredditEntity
import com.zhigaras.reddit.presentation.viewModels.SubscribableViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class AbstractSubredditsViewModel(
    private val mainRepository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SubscribableViewModel(mainRepository, ioDispatcher) {
    
    abstract fun getPagedSubreddits(query: String): Flow<PagingData<SubredditEntity>>
    
    fun saveCurrentSubreddit(subreddit: SubredditEntity) {
        viewModelScope.launch(ioDispatcher) {
            mainRepository.saveCurrentSubreddit(subreddit)
        }
    }
}