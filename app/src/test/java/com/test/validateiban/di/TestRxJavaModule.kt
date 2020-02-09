package com.test.validateiban.di

import com.test.validateiban.di.module.OBSERVER_ON
import com.test.validateiban.di.module.SUBCRIBER_ON
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class TestRxJavaModule {

    @Provides
    @Named(SUBCRIBER_ON)
    @Singleton
    fun provideSuscriberOn(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(OBSERVER_ON)
    @Singleton
    fun provideObserverOn(): Scheduler = AndroidSchedulers.mainThread()
}