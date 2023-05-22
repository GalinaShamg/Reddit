package com.zhigaras.reddit.presentation.viewModels.subreddits

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zhigaras.reddit.data.MainRepository
import com.zhigaras.reddit.di.IoDispatcher
import com.zhigaras.reddit.domain.model.SubredditEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchSubredditViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AbstractSubredditsViewModel(mainRepository, ioDispatcher) {
    
    override fun getPagedSubreddits(query: String): Flow<PagingData<SubredditEntity>> =
        mainRepository.getPagedSearchedSubredditsFlow(query).cachedIn(viewModelScope)
    
}