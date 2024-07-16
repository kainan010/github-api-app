package com.naniak.githubapi.features.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.naniak.githubapi.datamodel.GitResponseModel
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.features.home.repository.HomeRepository
import com.naniak.githubapi.utils.ResponseApi
import retrofit2.HttpException
import java.io.IOException

class GithubPagingSource(
    private val homeRepository: HomeRepository
): PagingSource<Int,Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        try {
            val page = params.key ?: 1
            val response = homeRepository.getRepositoryGithub(page)
            val listItem = when(response){
                is ResponseApi.Success ->{
                    (response.data as GitResponseModel).items
                }
                is ResponseApi.Error ->{
                    listOf()
                }
                else ->{
                    listOf()
                }
            }
            val prevKey = if (page==1) null else page -1
            val nextKey = if(listItem.isEmpty()) null else page +1
            return LoadResult.Page(
                listItem,
                null,
                nextKey
            )

        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e : HttpException){
            return LoadResult.Error(e)
        }
    }
}