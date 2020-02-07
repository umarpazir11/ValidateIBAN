package com.test.validateiban.di.module

import android.app.Application
import com.test.validateiban.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: BaseApplication) {

  @Provides
  @Singleton
  fun provideApplication(): Application {
    return app
  }

}
