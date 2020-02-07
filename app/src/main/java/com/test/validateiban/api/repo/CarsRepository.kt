package com.test.validateiban.api.repo

import android.util.Log
import com.test.validateiban.api.NetworkServices
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.RxJavaModule
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named


class CarsRepository @Inject constructor (private val networkServices : NetworkServices) {



    fun getBis(subscriberOn: Scheduler,observerOn: Scheduler,disposable: CompositeDisposable) {
        disposable.addAll(this.networkServices.getBlz("70020270")
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                //this.isLoading.value = true
            }
            .doOnComplete {
                //this.isLoading.value = false
            }
            .doOnError {
                //this.isLoading.value = false
            }
            .subscribe(
                {
                    Log.i("result", it.code)
                },
                {
                    it.printStackTrace()
                }
            ))
    }



}