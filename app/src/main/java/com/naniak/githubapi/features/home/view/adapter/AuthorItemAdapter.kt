package com.naniak.githubapi.features.home.view.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naniak.githubapi.databinding.ItemHomeBinding
import com.naniak.githubapi.datamodel.DataAuthor
import com.naniak.githubapi.datamodel.Item
import com.naniak.githubapi.datamodel.Item.Companion.DIFF_CALBACK

class AuthorItemAdapter(
    private val onClickListener: (binding: ItemHomeBinding) -> Unit
): PagingDataAdapter<Item,AuthorItemAdapter.ViewHolder>(DIFF_CALBACK) {

    class ViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind ( dataAuthor: Item?, onClickListener: (binding: ItemHomeBinding) -> Unit){
            binding.authorName.text = dataAuthor?.owner?.login
            binding.repoName.text = dataAuthor?.name
            Glide.with(itemView.context).load(dataAuthor?.owner?.avatarUrl).centerCrop()
                .into(binding.photoAuthor)
            binding.numberFork.text = dataAuthor?.forks.toString()
            binding.numberStar.text = dataAuthor?.stargazersCount.toString()
            binding.card.setOnClickListener { onClickListener(binding) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), onClickListener)

}