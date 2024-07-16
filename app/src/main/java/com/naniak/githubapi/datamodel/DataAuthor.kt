package com.naniak.githubapi.datamodel

data class DataAuthor(
    val authorName: String,
    val repositoryName: String,
    val image: String,
    val forksNumbers: Int,
    val starsNumbers: Int,
)