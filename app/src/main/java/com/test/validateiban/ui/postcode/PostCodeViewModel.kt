package com.test.validateiban.ui.postcode


import com.test.validateiban.api.repo.BankRepository
import com.test.validateiban.base.BaseViewModel
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named


class PostCodeViewModel@Inject constructor(private val bankRepository: BankRepository,
    @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler) : BaseViewModel() {

    val postCodeResponse = bankRepository.postCodeResponse

    val errorMessage = bankRepository.errorMessage

    fun validatePostCode(postCode: String,countryCode: String) {
        this.bankRepository.getPostCode(
            postCode,countryCode,
            subscriberOn,
            observerOn,
            this.disposable
        )
    }


}
