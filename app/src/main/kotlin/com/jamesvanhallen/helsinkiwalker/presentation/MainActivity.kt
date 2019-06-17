package com.jamesvanhallen.helsinkiwalker.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.extensions.replaceFragment
import com.jamesvanhallen.helsinkiwalker.presentation.venue.VenueFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoadingView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.replaceFragment(VenueFragment()).commit()
        }
        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        setTitle(R.string.app_name)
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        progressBackground.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        progress.visibility = View.GONE
        progressBackground.visibility = View.GONE
    }
}
