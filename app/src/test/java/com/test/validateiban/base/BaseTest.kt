package com.test.validateiban.base

import com.test.validateiban.di.DaggerTestAppComponent
import com.test.validateiban.di.TestAppComponent
import com.test.validateiban.di.TestRxJavaModule
import com.test.validateiban.di.factory.ViewModelFactory
import com.test.validateiban.di.module.NetModule
import com.test.validateiban.di.module.RepositoryModule
import org.junit.Before
import javax.inject.Inject
import kotlin.test.AfterTest

abstract class BaseTest {

    lateinit var testAppComponent: TestAppComponent
    @Inject lateinit var viewModelFactory: ViewModelFactory

    @Before
    open fun setUp(){
        this.configureDi()
    }

    @AfterTest
    open fun tearDown(){

    }

    // CONFIGURATION
    open fun configureDi(){
        this.testAppComponent = DaggerTestAppComponent.builder()
                .netModule(NetModule())
                .repositoryModule(RepositoryModule())
                .testRxJavaModule(TestRxJavaModule())
                .build()
        this.testAppComponent.inject(this)
    }

}