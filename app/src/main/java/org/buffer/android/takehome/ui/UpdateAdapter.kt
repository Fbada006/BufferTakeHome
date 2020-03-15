package org.buffer.android.takehome.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.update_item.view.*
import org.buffer.android.data.Update
import org.buffer.android.takehome.R
import org.buffer.android.takehome.util.formatTimeFromDb
import org.buffer.android.takehome.util.setUpdateImage

class UpdateAdapter : ListAdapter<Update, UpdateAdapter.UpdateViewHolder>(
    UpdateDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateViewHolder {
        return UpdateViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: UpdateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UpdateViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Update) {
            //Set the properly formatted time
            itemView.tv_update_time.text = formatTimeFromDb(item.dueAt)
            //Set the text
            itemView.tV_update_text.text = item.text
            //Set the visibility of the image view depending on whether it has an image
            setUpdateImage(item, itemView.iv_update_image)
        }

        companion object {
            fun from(parent: ViewGroup): UpdateViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.update_item, parent, false)
                return UpdateViewHolder(
                    view
                )
            }
        }
    }
}

@SuppressLint("DiffUtilEquals")
class UpdateDiffCallback : DiffUtil.ItemCallback<Update>() {
    override fun areItemsTheSame(oldItem: Update, newItem: Update): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Update, newItem: Update): Boolean {
        return oldItem == newItem
    }
}