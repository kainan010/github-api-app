package com.naniak.githubapi.features.home.repository

import com.naniak.githubapi.api.GitService
import com.naniak.githubapi.base.BaseRepository
import com.naniak.githubapi.utils.ResponseApi

class HomeRepository : BaseRepository()  {

    suspend fun getRepositoryGithub(page : Int): ResponseApi {
        return safeApiCall {
            GitService.gitApi.getRepositoryGithub(page)
        }
    }

}