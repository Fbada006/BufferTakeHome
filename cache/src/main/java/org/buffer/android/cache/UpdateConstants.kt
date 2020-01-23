package org.buffer.android.cache

object UpdateConstants {

    const val TABLE_NAME = "updates"

    const val COLUMN_NAME_ID = "update_id"

    const val COLUMN_NAME_PAGE = "update_page"

    const val COLUMN_NAME_STATUS = "update_status"

    const val COLUMN_NAME_PROFILE_ID = "update_profile_id"

    const val COLUMN_NAME_DUE_AT = "due_at"

    const val QUERY_DELETE_UPDATE =
            "DELETE FROM $TABLE_NAME WHERE $COLUMN_NAME_ID =:id"

    const val QUERY_DELETE_ALL_UPDATES = "DELETE FROM $TABLE_NAME"

    const val QUERY_UPDATES_BY_ID = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME_ID =:id"

    const val QUERY_DELETE_UPDATES_BY_CONTENT_STATUS_AND_PAGE = "DELETE FROM $TABLE_NAME WHERE " +
            "$COLUMN_NAME_PAGE =:page AND $COLUMN_NAME_STATUS =:status AND " +
            "$COLUMN_NAME_PROFILE_ID =:profileId"

    const val QUERY_UPDATES_BY_UPDATE_ID_AND_PROFILE_ID = "SELECT * FROM $TABLE_NAME WHERE " +
            "$COLUMN_NAME_ID IN (:ids)"

    internal fun makePlaceholders(len: Int): String {
        if (len < 1) {
            throw RuntimeException("No placeholders")
        } else {
            val sb = StringBuilder(len * 2 - 1)
            sb.append("?")
            for (i in 1..len - 1) {
                sb.append(",?")
            }
            return sb.toString()
        }
    }
}