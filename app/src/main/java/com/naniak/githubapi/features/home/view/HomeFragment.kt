package com.naniak.githubapi.features.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.naniak.githubapi.databinding.FragmentHomeBinding
import com.naniak.githubapi.features.home.view.adapter.AuthorItemAdapter
import com.naniak.githubapi.features.home.viewmodel.HomeViewModel
import com.naniak.githubapi.utils.Command
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    companion
    object {
        fun newInstance() = HomeFragment()
    }

    private var binding: FragmentHomeBinding? = null
    private val viewModel= HomeViewModel()

    private val adapter = AuthorItemAdapter {
        if (it.layoutInfo.isVisible) {
            it.layoutInfo.apply {
                visibility = View.GONE
                isVisible = false
            }
        } else {
            it.layoutInfo.apply {
                visibility = View.VISIBLE
                isVisible = true
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding?.run {
            vgRepository.layoutManager = LinearLayoutManager(context)
            vgRepository.adapter = adapter

        }
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.command = MutableLiveData<Command>()

        binding?.run {

            lifecycleScope.launch {
                viewModel.getRepositoryGithub().collectLatest {
                    adapter.submitData(it)
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }


}