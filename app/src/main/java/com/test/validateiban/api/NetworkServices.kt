package com.test.validateiban.api

import com.test.validateiban.ui.main.Bics
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface NetworkServices {


    @GET("searchBic")
    fun getBlz(
        @Query("blz") query: String? = null
    ): Observable<Bics>
}
