package com.uc.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.week4retrofit.adapter.NowPlayingAdapter
import com.uc.week4retrofit.databinding.ActivityMainBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapters: NowPlayingAdapter
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getNowPlaying(Const.API_KEY, "en-US",1)

        viewModel.nowplaying.observe(this, Observer{response->
            binding.rvMain.layoutManager = LinearLayoutManager(this)
            adapters = NowPlayingAdapter(response)
            binding.rvMain.adapter = adapters
        })



    }
}