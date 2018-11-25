package com.zech.disample.dagger2

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector
  abstract fun contributeLoginActivity(): LoginActivity
}