package org.buffer.android.takehome.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.buffer.android.data.Update
import java.text.SimpleDateFormat
import java.util.*

/**
 * This method handles converting time from milliseconds to the format hh:mm aa
 *
 * @param milliseconds is the time of the [Update] from the DB
 *
 */
@SuppressLint("SimpleDateFormat")
fun formatTimeFromDb(milliseconds: Long): String {
    val date = Date(milliseconds)
    val simpleFormatter = SimpleDateFormat("hh:mm aa")
    val timeString = simpleFormatter.format(date)
    //Since we know the exact values in this example, we can just make the last two characters lowercase
    //to stay in line with the design
    return timeString.replace("AM", "am").replace("PM", "pm")
}

/**
 * Set the visibility of the ImageView in the update_item.xml depending on whether the
 * Update has the imageUrl or not. If it has a URL, load it with Glide
 *
 * @param update is the [Update]
 *
 */
fun ImageView.setUpdateImage(update: Update) {
    val context = this.context
    if (update.imageUrl != null) {
        this.visibility = View.VISIBLE
        Glide.with(context)
            .load(getImageFromUpdate(context, update.imageUrl!!))
            .into(this)
    }
}

/**Helper method for getting the name of the drawable*/
private fun getImageFromUpdate(context: Context, imageUrl: String): Int =
    context.resources.getIdentifier(imageUrl, "drawable", context.packageName)
