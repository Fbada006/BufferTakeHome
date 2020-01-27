package org.buffer.android.cache

import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomString(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomInt(min: Int, max: Int): Int {
        return ThreadLocalRandom.current().nextInt(min, max)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }
}