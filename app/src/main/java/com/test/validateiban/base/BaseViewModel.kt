package com.test.validateiban.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * File Description
 *
 * Base for all ViewModels
 */
abstract class BaseViewModel: ViewModel() {

    protected var disposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        this.disposable.dispose()
        super.onCleared()
    }
}