package com.test.validateiban.api.repo

import android.util.Log
import com.test.validateiban.api.NetworkServices
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named


class CarsRepository(private val networkServices : NetworkServices) {

    fun getBics(value: String) = this.networkServices.getBlz("70020270")

  //  protected var disposable: CompositeDisposable = CompositeDisposable()



}