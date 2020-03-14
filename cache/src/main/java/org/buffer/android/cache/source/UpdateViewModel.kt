package org.buffer.android.cache.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.buffer.android.cache.source.Repository
import org.buffer.android.data.Update
import javax.inject.Inject

/**This class supplies the data to be presented to the UI*/
class UpdateViewModel @Inject constructor(repository: Repository): ViewModel() {

    /**The [LiveData] with the updates*/
    val updates: LiveData<List<Update>> = repository.getAllUpdates()
}