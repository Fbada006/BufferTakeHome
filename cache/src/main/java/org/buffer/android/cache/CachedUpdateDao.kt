package org.buffer.android.cache

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import org.buffer.android.data.Update

@Dao
interface CachedUpdateDao {

    @Query("SELECT * FROM  updates")
    fun getAllUpdates(): Flowable<List<CachedUpdate>>
}