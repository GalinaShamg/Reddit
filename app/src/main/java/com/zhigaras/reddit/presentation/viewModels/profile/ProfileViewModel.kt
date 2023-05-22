package com.zhigaras.reddit.presentation.viewModels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhigaras.reddit.data.MainRepository
import com.zhigaras.reddit.data.remote.response.user.UserDto
import com.zhigaras.reddit.di.IoDispatcher
import com.zhigaras.reddit.domain.ApiResult
import com.zhigaras.reddit.presentation.Communication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val communication: Communication.Base<ApiResult<UserDto>>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    
    fun getMyProfile() {
        viewModelScope.launch(ioDispatcher) {
            communication.map(ApiResult.Loading())
            val response = mainRepository.getMyProfile()
            communication.map(response)
        }
    }
    
    suspend fun observe(collector: FlowCollector<ApiResult<UserDto>?>) {
        communication.observe(collector)
    }
    
    fun logOut(intention: () -> Unit) {
        viewModelScope.launch {
            mainRepository.logOut()
            intention.invoke()
        }
    }
}