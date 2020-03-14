package org.buffer.android.cache

import org.buffer.android.cache.DataFactory.randomLong
import org.buffer.android.cache.DataFactory.randomString
import org.buffer.android.data.Update

object UpdateFactory {

    fun makeUpdate() = Update(randomString(), randomString(), randomLong(), randomString())

    fun makeCachedUpdate() = CachedUpdate(randomString(), randomString(), randomLong(), randomString())
}