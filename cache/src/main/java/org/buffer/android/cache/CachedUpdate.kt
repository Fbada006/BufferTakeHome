package org.buffer.android.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.buffer.android.cache.UpdateConstants.COLUMN_NAME_DUE_AT
import org.buffer.android.cache.UpdateConstants.COLUMN_NAME_ID
import org.buffer.android.cache.UpdateConstants.COLUMN_NAME_IMAGE_URL
import org.buffer.android.cache.UpdateConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class CachedUpdate(
    @ColumnInfo(name = COLUMN_NAME_ID)
    @PrimaryKey
    var id: String = "",
    val text: String? = null,
    @ColumnInfo(name = COLUMN_NAME_DUE_AT)
    var dueAt: Long = 0
//    @ColumnInfo(name = COLUMN_NAME_IMAGE_URL)
//    var imageUrl: String ? = null
)