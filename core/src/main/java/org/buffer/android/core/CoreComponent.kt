package org.buffer.android.core

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.buffer.android.cache.PublishDatabase
import org.buffer.android.core.module.ContextModule
import org.buffer.android.core.module.CoreModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    CoreModule::class
])
interface CoreComponent {

    @Component.Builder interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }

    fun context(): Context
    fun publishDatabase(): PublishDatabase
}