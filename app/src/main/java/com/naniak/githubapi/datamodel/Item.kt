package com.naniak.githubapi.datamodel

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Item(
    val forks: Int,
    val name: String,
    val owner: Owner,
    @SerializedName(value = "stargazers_count")
    val stargazersCount: Int
){
    companion object {
        var DIFF_CALBACK: DiffUtil.ItemCallback<Item> =
            object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem.name == newItem.name
                }

                override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem.forks == newItem.forks
                }
            }
    }
}