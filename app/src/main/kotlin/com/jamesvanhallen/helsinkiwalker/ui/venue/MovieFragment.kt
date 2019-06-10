package com.jamesvanhallen.helsinkiwalker.ui.venue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie
import kotlinx.android.synthetic.main.fmt_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val venueViewModel: VenueViewModel by viewModel()
    //private val movieAdapter = MovieAdapter(::onRatingChangeListener)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()
        setupViewModelLiveDates()
        initRecycler()
        //btnRandom.setOnClickListener { venueViewModel.rateRandomly() }
    }

    private fun setupViewModelLiveDates() {
        venueViewModel.run {
           // movies.observe(this@MovieFragment, Observer(::setData))
            //snackLiveData.observe(this@MovieFragment, Observer(::showCanceledSnack))
        }
    }

    private fun setupActionBar() {
        (activity as? AppCompatActivity)?.let {
            it.setSupportActionBar(toolbar)
            it.setTitle(R.string.app_name)
        }
    }

    private fun initRecycler() {
        rvMain.run {
           // adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
        }
    }

//    private fun setData(movies: List<Movie>) {
//        movieAdapter.items = movies
//    }

//    private fun onRatingChangeListener(movie: Movie) {
//        venueViewModel.onRatioChanged(movie)
//    }
}