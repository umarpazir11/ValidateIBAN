package com.test.validateiban.ui.ibanbic

import com.test.validateiban.api.repo.BankRepository
import com.test.validateiban.base.BaseViewModel
import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class BicIbanViewModel@Inject constructor(private val bankRepository: BankRepository,
                                          @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
                                          @param:Named(OBSERVER_ON) private val observerOn: Scheduler
) : BaseViewModel() {

    fun validateIBAN(iban: String) {
        this.bankRepository.validateIBAN(
            iban,
            subscriberOn,
            observerOn,
            this.disposable
        )
    }

    fun validateBic(bic: String) {
        this.bankRepository.validateBic(
            bic,
            subscriberOn,
            observerOn,
            this.disposable
        )
    }

    val ibanResponse = bankRepository.ibanResponse

}
