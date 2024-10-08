package com.example.project3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieRecyclerViewAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieItem: Movie? = null

        var titleTextView: TextView = itemView.findViewById(R.id.movieTitle) as TextView
        var overviewTextView: TextView = itemView.findViewById(R.id.movieOverview) as TextView
        var posterImageView: ImageView = itemView.findViewById(R.id.moviePoster) as ImageView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.movieItem = movie
        holder.titleTextView.text = movie.title
        holder.overviewTextView.text = movie.overview
        Glide.with(holder.itemView.context)
            .load(movie.getPosterUrl())
            .apply(RequestOptions().placeholder(R.drawable.smiley))
            .into(holder.posterImageView)
    }

    override fun getItemCount(): Int = movies.size
}
