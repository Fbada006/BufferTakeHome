package org.buffer.android.core.di

import org.buffer.android.core.CoreComponent

/**
 * Provides the core Dagger DI Component.
 *
 * The core module needs an application context as DI root. Therefor, the application classes of the apps using this module
 * should implement [CoreComponentProvider].
 */
interface CoreComponentProvider {
    /**
     * Returns the CoreComponent / DI root.
     */
    fun provideCoreComponent(): CoreComponent
}