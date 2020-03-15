package org.buffer.android.takehome

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.buffer.android.core.coreComponent
import org.buffer.android.takehome.ui.UpdateAdapter
import org.buffer.android.queue.UpdateViewModel

class MainActivity : AppCompatActivity() {

    private val updateViewModel: UpdateViewModel by viewModels { coreComponent().viewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val adapter = UpdateAdapter()
        updates_list.adapter = adapter

        updateViewModel.updates.observe(this, Observer { updates ->
            adapter.submitList(updates)
        })
    }
}
