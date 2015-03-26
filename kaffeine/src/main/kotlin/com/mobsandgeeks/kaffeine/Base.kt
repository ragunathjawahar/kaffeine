/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobsandgeeks.kaffeine

import kotlin.properties.ReadOnlyProperty


/**
 * Base trait that can be used for implementing lazy property delegates of read-only properties.
 * This is provided only for convenience; you don't have to extend this trait as long as your
 * property delegate has methods with the same signatures.
 *
 * @param R the type of object which owns the delegated property.
 * @param T the type of the property value.
 */
public trait ReadOnlyLazyDelegate<R, T> : ReadOnlyProperty<R, T> {
    protected fun lazy(): T

    override fun get(thisRef: R, desc: PropertyMetadata): T = lazy()
}
