package com.test.validateiban.di.bulider

import com.test.validateiban.MainActivity
import com.test.validateiban.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment

}
