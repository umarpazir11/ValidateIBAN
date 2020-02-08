package com.test.validateiban.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.validateiban.di.ViewModelKey

import com.test.validateiban.di.factory.ViewModelFactory
import com.test.validateiban.ui.ibanbic.BicIbanViewModel
import com.test.validateiban.ui.postcode.PostCodeViewModel
import com.test.validateiban.ui.routingcode.SearchRoutingCodeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchRoutingCodeViewModel::class)
    abstract fun mainViewModel(viewModel: SearchRoutingCodeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostCodeViewModel::class)
    abstract fun postCodeViewModel(viewModel: PostCodeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BicIbanViewModel::class)
    abstract fun bicIbanViewModel(viewModel: BicIbanViewModel): ViewModel

}

