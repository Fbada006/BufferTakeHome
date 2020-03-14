package org.buffer.android.core.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.buffer.android.cache.source.UpdateViewModel
import org.buffer.android.core.ViewModelKey

/**Handles creation of [ViewModel]*/
@Module
abstract class ViewModelsModule {

    /**Create the [UpdateViewModel]*/
    @Binds
    @IntoMap
    @ViewModelKey(UpdateViewModel::class)
    abstract fun bindUpdateViewModel(viewModel: UpdateViewModel): ViewModel

}