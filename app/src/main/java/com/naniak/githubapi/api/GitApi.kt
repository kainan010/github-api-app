package com.naniak.githubapi.api

import com.naniak.githubapi.datamodel.GitResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitApi {
    @GET("repositories?q=language:kotlin&sort=stars")
    suspend fun   getRepositoryGithub(
        @Query("page") page:Int
    ): Response<GitResponseModel>
}