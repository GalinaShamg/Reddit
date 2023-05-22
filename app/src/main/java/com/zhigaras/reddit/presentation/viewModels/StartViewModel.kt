package com.zhigaras.reddit.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhigaras.reddit.data.MainRepository
import com.zhigaras.reddit.di.IoDispatcher
import com.zhigaras.reddit.presentation.Communication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val communication: Communication.Base<Boolean>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    
    fun checkAccessToken() {
        viewModelScope.launch(ioDispatcher) {
            val result = mainRepository.checkAccessToken()
            communication.map(result)
        }
    }
    
    suspend fun observe(collector: FlowCollector<Boolean?>) {
        communication.observe(collector)
    }
}