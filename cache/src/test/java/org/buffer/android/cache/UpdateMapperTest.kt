package org.buffer.android.cache

import org.buffer.android.cache.UpdateFactory.makeCachedUpdate
import org.junit.Test

import org.junit.Assert.*

class UpdateMapperTest {

    private val updateMapper = UpdateMapper()

    @Test
    fun `Map from cache correctly maps data`() {
        val cachedUpdate = makeCachedUpdate()
        val update = updateMapper.mapFromCache(cachedUpdate)

        assertEquals(cachedUpdate.id, update.id)
        assertEquals(cachedUpdate.text, update.text)
        assertEquals(cachedUpdate.dueAt, update.dueAt)
    }
}
