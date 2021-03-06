package org.buffer.android.queue

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.buffer.android.cache.CachedUpdateDao
import org.buffer.android.cache.UpdateMapper
import org.buffer.android.data.Update
import javax.inject.Inject

/**The source of data for the app*/
class Repository @Inject constructor(private val cachedUpdateDao: CachedUpdateDao) {

    /**Get the data and return a [LiveData] object to present to the ViewModel
     * The mapper maps each [CachedUpdate] to [Update] which is what is shown in the UI
     * */
    fun getAllUpdates(): LiveData<List<Update>> {
        val mapper = UpdateMapper()

        return cachedUpdateDao.getAllUpdates()
            .flatMapSingle { cachedUpdatesList ->
                Observable.fromIterable(cachedUpdatesList)
                    .map { cachedUpdate ->
                        mapper.mapFromCache(cachedUpdate)
                    }.toList()
            }
            .onErrorReturn {
                emptyList()
            }
            .subscribeOn(Schedulers.io())
            .to { flowableUpdates ->
                LiveDataReactiveStreams.fromPublisher(flowableUpdates)
            }
//
//        val allUpdates = cachedUpdateDao.getAllUpdates()
//        return allUpdates.switchMap { cachedUpdatesList ->
//                Flowable.fromIterable(cachedUpdatesList)
//                    .map { cachedUpdate ->
//                        mapper.mapFromCache(cachedUpdate)
//                    }
//            }.toList()
//            .onErrorReturn {
//                emptyList<Update>()
//            }
//            .subscribeOn(Schedulers.io())
//            .to { flowableUpdates ->
//                LiveDataReactiveStreams.fromPublisher(flowableUpdates.toFlowable())
//            }
    }
}