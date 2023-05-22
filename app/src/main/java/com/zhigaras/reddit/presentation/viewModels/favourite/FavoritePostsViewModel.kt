package com.zhigaras.reddit.presentation.viewModels.favourite

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zhigaras.reddit.data.MainRepository
import com.zhigaras.reddit.di.IoDispatcher
import com.zhigaras.reddit.domain.model.PostEntity
import com.zhigaras.reddit.presentation.viewModels.PostsViesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@HiltViewModel
class FavoritePostsViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PostsViesModel(mainRepository, ioDispatcher) {
    
    override fun getPagedPosts(subredditName: String): Flow<PagingData<PostEntity>> {
        return mainRepository.getPagedFavoritePosts().cachedIn(viewModelScope)
    }
}