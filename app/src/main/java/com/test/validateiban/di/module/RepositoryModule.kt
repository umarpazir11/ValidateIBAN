package com.test.validateiban.di.module

import com.test.validateiban.api.NetworkServices
import com.test.validateiban.api.repo.CarsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun provideUserRepository(bankApiService: NetworkServices) = CarsRepository(bankApiService)

}