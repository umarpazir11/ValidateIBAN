package com.test.validateiban.di

import com.test.validateiban.base.BaseTest
import com.test.validateiban.di.module.NetModule
import com.test.validateiban.di.module.RepositoryModule
import com.test.validateiban.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, RepositoryModule::class, ViewModelModule::class, TestRxJavaModule::class])
interface TestAppComponent {
    fun inject(baseTest: BaseTest)
}