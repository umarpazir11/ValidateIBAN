package com.test.validateiban.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.validateiban.di.ViewModelKey

import com.test.validateiban.di.factory.ViewModelFactory
import com.test.validateiban.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mapViewModel(viewModel: MainViewModel): ViewModel

}

