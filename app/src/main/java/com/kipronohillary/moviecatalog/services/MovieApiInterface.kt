package com.kipronohillary.moviecatalog.services

import com.kipronohillary.moviecatalog.modals.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=76072432101bd23b93e66e46f9364a64")
    fun  getMovieList(): Call<MovieResponse>
}