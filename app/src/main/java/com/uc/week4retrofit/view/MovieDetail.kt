package com.uc.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.uc.week4retrofit.databinding.ActivityMovieDetailBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MovieDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var nowPlayingViewModel: MoviesViewModel
    private lateinit var viewModel: MoviesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra("movie_id", 0)
        Toast.makeText(applicationContext, "Movie ID: ${movieId}", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(Const.API_KEY, movieId)
        viewModel.movieDetails.observe(this) { response ->
            binding.tvTitleMovieDetail.apply {
                text = response.title
            }

            Glide.with(applicationContext)
                .load(Const.IMG_URL + response.backdrop_path)
                .into(binding.imgPosterMovieDetail)


        }
        nowPlayingViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
    }
}