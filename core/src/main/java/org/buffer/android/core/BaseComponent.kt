package org.buffer.android.core

import android.app.Activity
import android.app.Service

interface BaseComponent<T> {

    fun inject(target: T)
}

interface BaseActivityComponent<T : Activity> : BaseComponent<T>

interface BaseServiceComponent<T : Service> : BaseComponent<T>