package com.test.validateiban.di.bulider


import com.test.validateiban.BanksInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * File Description
 *
 * For listing all activities to work with a dagger
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    internal abstract fun bankInfoActivity(): BanksInfoActivity



}
