package org.buffer.android.takehome

import android.app.Application
import org.buffer.android.core.CoreComponent
import org.buffer.android.core.DaggerCoreComponent
import org.buffer.android.core.di.CoreComponentProvider

class BufferApp: Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}