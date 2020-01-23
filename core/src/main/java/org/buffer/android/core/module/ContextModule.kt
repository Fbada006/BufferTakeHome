package org.buffer.android.core.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context = application
}