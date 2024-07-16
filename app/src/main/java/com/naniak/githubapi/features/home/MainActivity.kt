package com.naniak.githubapi.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naniak.githubapi.R
import com.naniak.githubapi.databinding.ActivityMainBinding
import com.naniak.githubapi.features.home.view.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}