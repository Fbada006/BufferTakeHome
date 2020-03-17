package org.buffer.android.takehome

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.buffer.android.core.ViewModelFactory
import org.buffer.android.core.coreComponent
import org.buffer.android.queue.UpdateViewModel
import org.buffer.android.takehome.di.DaggerAppComponent
import org.buffer.android.takehome.ui.UpdateAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val updateViewModel: UpdateViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        setSupportActionBar(toolbar)
        val adapter = UpdateAdapter()
        updates_list.adapter = adapter

        updateViewModel.updates.observe(this, Observer { updates ->
            adapter.submitList(updates)
        })
    }
}
