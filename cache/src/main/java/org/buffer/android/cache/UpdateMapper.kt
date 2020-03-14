package org.buffer.android.cache

import org.buffer.android.data.Update

class UpdateMapper {

    fun mapFromCache(
        cachedUpdate: CachedUpdate
    ) =  Update(cachedUpdate.id, cachedUpdate.text, cachedUpdate.dueAt)
}