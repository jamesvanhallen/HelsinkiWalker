package com.jamesvanhallen.helsinkiwalker.ui.venue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import com.jamesvanhallen.helsinkiwalker.ui.LoadingView
import kotlinx.android.synthetic.main.fmt_venue.*
import org.koin.android.viewmodel.ext.android.viewModel

class VenueFragment : Fragment() {

    private val venueViewModel: VenueViewModel by viewModel()
    private val movieAdapter = VenueAdapter(::onRatingChangeListener)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_venue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelLiveDates()
        initRecycler()
    }

    private fun setupViewModelLiveDates() {
        venueViewModel.run {
            init()
            venues.observe(this@VenueFragment, Observer(::setData))
            loading.observe(this@VenueFragment, Observer(::showLoading))
            error.observe(this@VenueFragment, Observer(::showError))
        }
    }

    private fun initRecycler() {
        rvMain.run {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
        }
    }

    private fun setData(venues: List<Venue>) {
        movieAdapter.items = venues
    }

    private fun onRatingChangeListener(venue: Venue) {
        venueViewModel.onFavoriteSelected(venue)
    }

    private fun showError(throwable: Throwable?) {
        throwable?.message?.let {
            Snackbar.make(rvMain, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun showLoading(show: Boolean) {
        val loadingView = requireActivity() as LoadingView
        if (show) {
            loadingView.showLoading()
        } else {
            loadingView.dismissLoading()
        }
    }
}