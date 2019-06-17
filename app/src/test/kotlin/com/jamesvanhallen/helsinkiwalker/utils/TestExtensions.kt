package com.jamesvanhallen.helsinkiwalker.utils

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.test() = TestObserver<T>().also {
    observeForever(it)
}