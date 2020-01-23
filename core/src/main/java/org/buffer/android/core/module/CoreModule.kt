package org.buffer.android.core.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.buffer.android.cache.PublishDatabase
import javax.inject.Singleton

@Module
open class CoreModule {

    @Provides
    @Singleton
    internal fun providePublishDatabase(context: Context): PublishDatabase {
        return PublishDatabase.getInstance(context)
    }
}