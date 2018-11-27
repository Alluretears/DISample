package com.zech.disample.dagger2

import com.zech.disample.ApiService
import com.zech.disample.FakeApiServiceImpl
import com.zech.disample.FakeApiServiceImpl2
import dagger.Binds
import dagger.Module

@Module
abstract class ApiModule {
    @Binds
    @Impl
    abstract fun impl(impl: FakeApiServiceImpl): ApiService

    @Binds
    @Impl2
    abstract fun impl2(impl2: FakeApiServiceImpl2): ApiService
}
