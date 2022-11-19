package com.kipronohillary.moviecatalog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cronocode.moviecatalog.MovieAdapter
import com.kipronohillary.moviecatalog.databinding.ActivityMainBinding
import com.kipronohillary.moviecatalog.modals.Movie
import com.kipronohillary.moviecatalog.modals.MovieResponse
import com.kipronohillary.moviecatalog.services.MovieApiInterface
import com.kipronohillary.moviecatalog.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMoviesList.layoutManager=LinearLayoutManager(this)
        binding.rvMoviesList.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            binding.rvMoviesList.adapter=MovieAdapter(applicationContext,movies)

    }

}

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
      apiService.getMovieList().enqueue(object :Callback<MovieResponse>{
          override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
          return callback(response.body()!!.movies)
          }

          override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
              TODO("Not yet implemented")
          }

      })



    }
}