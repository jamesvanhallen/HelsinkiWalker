package com.jamesvanhallen.helsinkiwalker.presentation.venue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.presentation.LoadingView
import kotlinx.android.synthetic.main.fmt_venue.*
import org.koin.android.viewmodel.ext.android.viewModel

class VenueFragment : Fragment() {

    private val venueViewModel: VenueViewModel by viewModel()
    private val venueAdapter = VenueAdapter(::onRatingChangeListener)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_venue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    override fun onStart() {
        super.onStart()
        setupViewModelLiveDates()
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
            adapter = venueAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
        }
    }

    private fun setData(venues: List<Venue>) {
        venueAdapter.items = venues
    }

    private fun onRatingChangeListener(venue: Venue) {
        venueViewModel.onFavoriteSelected(venue)
    }

    override fun onStop() {
        super.onStop()
        venueViewModel.stopTimer()
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