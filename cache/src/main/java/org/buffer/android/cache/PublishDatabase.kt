package org.buffer.android.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [CachedUpdate::class], version = 1)
abstract class PublishDatabase @Inject constructor() : RoomDatabase() {

    companion object {
        private val sLock = Any()

        private var INSTANCE: PublishDatabase? = null

        fun getInstance(context: Context): PublishDatabase {
            if (INSTANCE == null) {
                synchronized(sLock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            PublishDatabase::class.java, "buffer_publish.db")
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                    return INSTANCE!!
                }
            }
            return INSTANCE!!
        }
    }
}