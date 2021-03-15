package com.jamesvanhallen.helsinkiwalker.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val error = MutableLiveData<Throwable>()
    val loading = MutableLiveData<Boolean>()

    protected fun launchCatching(
        errorHandler: (Throwable) -> Unit = ::handleRequestError,
        showProgress: Boolean = true,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch {
        try {
            if (showProgress) {
                loading.postValue(true)
            }
            block()
        } catch (t: Throwable) {
            errorHandler(t)
        } finally {
            if (showProgress) {
                loading.postValue(false)
            }
        }
    }

    private fun handleRequestError(throwable: Throwable) {
        error.postValue(throwable) }

}