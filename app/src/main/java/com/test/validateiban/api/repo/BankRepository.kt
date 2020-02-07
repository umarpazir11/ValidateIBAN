package com.test.validateiban.api.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.test.validateiban.api.NetworkServices
import com.test.validateiban.ui.model.Bic
import com.test.validateiban.ui.model.Bics
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class BankRepository @Inject constructor (private val networkServices : NetworkServices) {


    val  bics: MutableLiveData<List<Bic>?> = MutableLiveData()

    fun getBankRoutingCodes(routingCode: String,subscriberOn: Scheduler,
                            observerOn: Scheduler,disposable: CompositeDisposable) {
        disposable.addAll(this.networkServices.getBankRoutingCodes(routingCode)
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
                    bics.postValue(it.data.bics)
                },
                {
                    it.printStackTrace()
                }
            ))
    }



}