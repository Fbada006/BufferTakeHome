package org.buffer.android.core

import android.app.Activity
import org.buffer.android.core.di.component.CoreComponentProvider

fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")