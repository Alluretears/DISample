package com.zech.disample

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.zech.disample.dagger2.DaggerAppComponent
import com.zech.disample.koin.appModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import org.koin.android.ext.android.startKoin
import javax.inject.Inject

class DIApp : Application(), HasActivityInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

  override fun onCreate() {
    super.onCreate()
    Stetho.initializeWithDefaults(this)
    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this)
    startKoin(this, listOf(appModule))
  }
}