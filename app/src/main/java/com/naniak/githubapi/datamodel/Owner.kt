package com.naniak.githubapi.datamodel

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName(value = "avatar_url")
    val avatarUrl: String,
    val login: String
)