package com.test.validateiban.api

import com.test.validateiban.ui.ibanbic.model.IBAN
import com.test.validateiban.ui.routingcode.model.Bics
import com.test.validateiban.ui.postcode.model.PostCodeResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * API calls interface
 */
interface NetworkServices {


    @GET("searchBic")
    fun getBankRoutingCodes(@Query("blz") blz: String? = null): Observable<Bics>

    @GET("validateBic")
    fun validateBic(@Query("bic") bic: String? = null): Observable<IBAN>

    @GET("validateIban")
    fun validateIban(@Query("iban") iban: String? = null): Observable<IBAN>

    @GET("validatePostCode")
    fun validatePostCode(@Query("countryCode") countryCode: String? = null,
                         @Query("postCode") postCode: String? = null
    ): Observable<PostCodeResponse>
}
