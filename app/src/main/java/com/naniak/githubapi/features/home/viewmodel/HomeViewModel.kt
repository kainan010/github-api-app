package com.naniak.githubapi.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.naniak.githubapi.base.BaseViewModel
import com.naniak.githubapi.datamodel.GitResponseModel
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.paging.GithubPagingSource
import com.naniak.githubapi.features.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

private const val PAGESIZE = 30

class HomeViewModel() : BaseViewModel() {

    private val _onSuccessRepositoryGithub: MutableLiveData<GitResponseModel> =
        MutableLiveData()
    val onSuccessRepositoryGithub: LiveData<GitResponseModel>
        get() = _onSuccessRepositoryGithub

    private val _onErrorRepositoryGithub: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorRepositoryGithub: LiveData<Int>
        get() = _onErrorRepositoryGithub


    fun getRepositoryGithub(): Flow<PagingData<Item>> {
        return Pager(
            PagingConfig(pageSize = PAGESIZE, enablePlaceholders = false)
        ) {
            GithubPagingSource(HomeRepository())
        }.flow.cachedIn(viewModelScope)


    }

    /* suspend fun getRepositoryGithub(): ResponseApi {
       return when (val responseApi = homeRepository.getRepositoryGithub()) {
           is ResponseApi.Success -> {
               val data = responseApi.data as Item

               ResponseApi.Success(data)
           }
           is ResponseApi.Error -> {
               responseApi
           }

           else -> responseApi
       }
   }*/

    /*suspend fun getRepositoryGithub() =
        homeRepository.getRepositoryGithub()*/


    /*  fun getRepositoryGithub() {
          viewModelScope.launch {
              this@HomeViewModel.callApi(
                  call = { homeUseCase.getRepositoryGithub()},
                  onSuccess = { _onSuccessRepositoryGithub.postValue(it as GitResponseModel) }
              )
          }
      }*/
}