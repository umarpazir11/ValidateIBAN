package com.test.validateiban.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.test.validateiban.api.repo.CarsRepository
import com.test.validateiban.base.BaseViewModel
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class MainViewModel @Inject constructor(
    private val carRepository: CarsRepository,
    @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler
) : BaseViewModel() {
    fun getBis() {
        this.disposable.addAll(this.carRepository.getBics("70020270")
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
