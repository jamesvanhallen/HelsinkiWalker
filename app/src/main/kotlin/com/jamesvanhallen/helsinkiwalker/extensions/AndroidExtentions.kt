package com.jamesvanhallen.helsinkiwalker.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData

fun FragmentManager.replaceFragment(fragment: Fragment): Transaction {
    return Transaction(
        this,
        fragment,
        Transaction.Type.REPLACE
    )
}

fun <T> LiveData<T>.test() = TestObserver<T>().also {
    observeForever(it)
}