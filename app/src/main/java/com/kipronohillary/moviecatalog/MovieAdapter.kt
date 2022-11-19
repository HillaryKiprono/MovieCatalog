package com.cronocode.moviecatalog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kipronohillary.moviecatalog.R
import com.kipronohillary.moviecatalog.modals.Movie


class MovieAdapter(
    private var context:Context, private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){


        var mtitle:TextView=itemView.findViewById(R.id.movie_title)
        var mdate:TextView=itemView.findViewById(R.id.movie_release_date)
        var mImage:ImageView=itemView.findViewById(R.id.movie_poster)
//        fun bindMovie(movie : Movie){
//            itemView.movie_title.text = movie.title
//            itemView.movie_release_date.text = movie.release
//            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       // holder.bindMovie(movies.get(position))
         val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        var currentMovie=movies[position]
        holder.mtitle.text=currentMovie.title
        holder.mdate.text=currentMovie.release

        Glide.with(context).load(IMAGE_BASE+ movies[position].poster).into(holder.mImage)
    }
}