package com.test.validateiban.ui.routingcode

import com.test.validateiban.api.repo.BankRepository
import com.test.validateiban.base.BaseViewModel
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class SearchRoutingCodeViewModel @Inject constructor(
    private val bankRepository: BankRepository,
    @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler
) : BaseViewModel() {

    val bankData = bankRepository.bicsResponse

    val isLoading = bankRepository.isLoading
    val errorMessage = bankRepository.errorMessage


    init {
        this.isLoading.value = false
    }

    fun fetchBics(routingCode: String) {
        this.bankRepository.getBankRoutingCodes(
            routingCode,
            subscriberOn,
            observerOn,
            this.disposable
        )
    }

}
