package org.buffer.android.core.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.buffer.android.cache.PublishDatabase
import javax.inject.Singleton

@Module
open class CoreModule {

    @Provides
    @Singleton
    internal fun providePublishDatabase(context: Context) = PublishDatabase.getInstance(context)

    @Provides
    @Singleton
    internal fun provideCachedDao(database: PublishDatabase) = database.cachedUpdateDao
}