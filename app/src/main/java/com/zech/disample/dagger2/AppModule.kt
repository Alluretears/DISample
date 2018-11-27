package com.zech.disample.dagger2

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.zech.disample.ApiService
import com.zech.disample.FakeApiServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Named("default")
    @Singleton
    @Provides
    fun provideDefaultSharePreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Named("app")
    @Singleton
    @Provides
    fun provideAppSharePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("app", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return FakeApiServiceImpl()
    }
}
