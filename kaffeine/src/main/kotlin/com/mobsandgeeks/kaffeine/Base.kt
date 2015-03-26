package com.mobsandgeeks.kaffeine

import kotlin.properties.ReadOnlyProperty


public trait ReadOnlyLazyDelegate<T, R> : ReadOnlyProperty<R, T> {
    protected fun lazy(): T

    override fun get(thisRef: R, desc: PropertyMetadata): T = lazy()
}
