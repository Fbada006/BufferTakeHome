package org.buffer.android.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import javax.inject.Inject

//Since it is an update, the version needs to be increased as well
@Database(entities = [CachedUpdate::class], version = 2)
abstract class PublishDatabase @Inject constructor() : RoomDatabase() {

    abstract val cachedUpdateDao: CachedUpdateDao

    companion object {
        private val sLock = Any()

        private var INSTANCE: PublishDatabase? = null

        fun getInstance(context: Context): PublishDatabase {
            if (INSTANCE == null) {
                synchronized(sLock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                                context.applicationContext,
                                PublishDatabase::class.java, "buffer_publish.db"
                            )
                            .allowMainThreadQueries()
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    db.execSQL(defaultData)
                                }
                            })
                            .build()
                    }
                    return INSTANCE!!
                }
            }
            return INSTANCE!!
        }

        private const val defaultData = "INSERT INTO updates (update_id, text, due_at, image_url) VALUES " +
                "('5e29c538841ff2689b2d2dbf', 'My first update!', 1589446800, NULL), " +
                "('5e29c52d7b275069a343c275', 'This is an update that should have an image. Figured I would just" +
                "show an android poster', " +
                "1588270140, 'android_image'), " +
                "('5e29c54f33e59566ea3410f7', 'This update has a little bit more text than the " +
                "previous ones. It is the third update in the list and the one with the most " +
                "text also!', 1593108540, NULL)"
    }
}