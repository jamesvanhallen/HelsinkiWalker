package com.jamesvanhallen.helsinkiwalker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.extensions.replaceFragment
import com.jamesvanhallen.helsinkiwalker.ui.venue.MovieFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.replaceFragment(MovieFragment()).commit()
        }
    }
}
