package org.buffer.android.takehome.di

import dagger.Component
import org.buffer.android.core.di.component.CoreComponent
import org.buffer.android.takehome.MainActivity

@AppScope
@Component(dependencies = [CoreComponent::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}