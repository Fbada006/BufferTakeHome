package org.buffer.android.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import org.buffer.android.core.ViewModelFactory
import org.buffer.android.core.ViewModelFactoryModule
import org.buffer.android.core.di.module.ContextModule
import org.buffer.android.core.di.module.CoreModule
import org.buffer.android.core.di.module.ViewModelsModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        CoreModule::class,
        ViewModelFactoryModule::class,
        ViewModelsModule::class
    ]
)
interface CoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }

    fun viewModelFactory(): ViewModelFactory
}