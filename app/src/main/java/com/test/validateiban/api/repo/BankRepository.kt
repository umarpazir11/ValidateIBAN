package com.test.validateiban.api.repo

import androidx.lifecycle.MutableLiveData
import com.test.validateiban.api.NetworkServices
import com.test.validateiban.ui.ibanbic.model.IBAN
import com.test.validateiban.ui.routingcode.model.Bic
import com.test.validateiban.ui.postcode.model.PostCodeResponse
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For Handling all data from APIs
 * @property networkServices is interface for API Calls
 */
class BankRepository @Inject constructor(private val networkServices: NetworkServices) {

    val bicsResponse: MutableLiveData<List<Bic>?> = MutableLiveData()
    val postCodeResponse: MutableLiveData<PostCodeResponse> = MutableLiveData()
    val ibanResponse: MutableLiveData<IBAN> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

    fun getBankRoutingCodes(
        routingCode: String, subscriberOn: Scheduler,
        observerOn: Scheduler, disposable: CompositeDisposable
    ) {
        disposable.addAll(this.networkServices.getBankRoutingCodes(routingCode)
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                this.isLoading.value = true
            }
            .doOnComplete {
                this.isLoading.value = false
            }
            .doOnError {
                this.isLoading.value = false
                it.printStackTrace()
            }
            .subscribe(
                {
                    this.isLoading.value = false
                    bicsResponse.postValue(it.data.bics)
                },
                {
                    this.isLoading.value = false
                    it.printStackTrace()
                    this.errorMessage.value = it.message

                }
            ))
    }

    fun validateBic(
        bic: String, subscriberOn: Scheduler,
        observerOn: Scheduler, disposable: CompositeDisposable
    ) {
        disposable.addAll(this.networkServices.validateBic(bic)
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                this.isLoading.value = true
            }
            .doOnComplete {
                this.isLoading.value = false
            }
            .doOnError {
                this.isLoading.value = false

                it.printStackTrace()
            }
            .subscribe(
                {
                    this.isLoading.value = false
                    ibanResponse.postValue(it)
                },
                {
                    this.isLoading.value = false
                    it.printStackTrace()
                    this.errorMessage.value = it.message

                }
            ))
    }

    fun validateIBAN(
        iban: String, subscriberOn: Scheduler,
        observerOn: Scheduler, disposable: CompositeDisposable
    ) {
        disposable.addAll(this.networkServices.validateIban(iban)
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                this.isLoading.value = true
            }
            .doOnComplete {
                this.isLoading.value = false
            }
            .doOnError {
                this.isLoading.value = false
                it.printStackTrace()
            }
            .subscribe(
                {
                    this.isLoading.value = false
                    ibanResponse.postValue(it)
                },
                {
                    this.isLoading.value = false
                    this.errorMessage.value = it.message
                    it.printStackTrace()
                }
            ))
    }


    fun getPostCode(
        isoCode: String, postCode: String, subscriberOn: Scheduler,
        observerOn: Scheduler, disposable: CompositeDisposable
    ) {
        disposable.addAll(this.networkServices.validatePostCode(isoCode, postCode)
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                this.isLoading.value = true
            }
            .doOnComplete {
                this.isLoading.value = false
            }
            .doOnError {
                this.isLoading.value = false
                it.printStackTrace()
            }
            .subscribe(
                {
                    this.isLoading.value = false
                    postCodeResponse.postValue(it)
                },
                {
                    this.isLoading.value = false
                    this.errorMessage.value = it.message
                    it.printStackTrace()
                }
            ))
    }

}