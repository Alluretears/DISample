package com.zech.disample.koin

import android.content.Context
import android.preference.PreferenceManager
import com.zech.disample.ApiService
import com.zech.disample.FakeApiServiceImpl
import com.zech.disample.LoginManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {
    single<ApiService> { FakeApiServiceImpl() }
    single(name = "default") { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
    single(name = "app") { androidContext().getSharedPreferences("app", Context.MODE_PRIVATE) }
    single { LoginManager(get(), get(name = "default")) }
}