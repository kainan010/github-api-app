package com.naniak.githubapi.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GitService {

    val gitApi: GitApi = getGitApiClient().create(GitApi::class.java)

    const val URL = "https://api.github.com/search/"

    fun getGitApiClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG){
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()

        return interceptor
    }

}