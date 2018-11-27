package com.zech.disample.dagger2

import android.app.Application
import com.zech.disample.DIApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: DIApp)
}
