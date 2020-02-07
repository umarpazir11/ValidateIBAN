package com.test.validateiban.api

import com.test.validateiban.ui.model.Bics
import io.reactivex.Observable
import retrofit2.http.*

interface NetworkServices {


    @GET("searchBic")
    fun getBankRoutingCodes(
        @Query("blz") query: String? = null
    ): Observable<Bics>

    @GET("validateBic")
    fun validateBic(
        @Query("bic") query: String? = null
    ): Observable<Bics>
}
