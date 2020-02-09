package com.test.validateiban.di.bulider

import com.test.validateiban.ui.ibanbic.BicIBANFragment
import com.test.validateiban.ui.postcode.PostCodeFragment
import com.test.validateiban.ui.routingcode.SearchRoutingCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * File Description
 *
 * For listing all fragments to work with a dagger
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun searchRoutingCodeFragment(): SearchRoutingCodeFragment

    @ContributesAndroidInjector
    internal abstract fun postCodeFragment(): PostCodeFragment

    @ContributesAndroidInjector
    internal abstract fun bicIBANFragment(): BicIBANFragment

}
