package com.test.validateiban.di.component

import android.app.Application
import com.test.validateiban.base.BaseApplication
import com.test.validateiban.di.bulider.ActivityBuilderModule
import com.test.validateiban.di.module.NetModule
import com.test.validateiban.di.module.RepositoryModule
import com.test.validateiban.di.module.RxJavaModule
import com.test.validateiban.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetModule::class, ActivityBuilderModule::class,
    RepositoryModule::class, ViewModelModule::class, RxJavaModule::class])
interface AppComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}