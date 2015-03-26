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

import android.util.Log


public fun Any.v(message: String) {
    v(this.javaClass.getName(), message)
}

public fun Any.d(message: String) {
    d(this.javaClass.getName(), message)
}

public fun Any.i(message: String) {
    i(this.javaClass.getName(), message)
}

public fun Any.w(message: String) {
    w(this.javaClass.getName(), message)
}

public fun Any.e(message: String) {
    e(this.javaClass.getName(), message)
}

public fun Any.wtf(message: String) {
    wtf(this.javaClass.getName(), message)
}

public fun Any.v(tag: String, message: String) {
    v(tag, message, null)
}

public fun Any.d(tag: String, message: String) {
    d(tag, message, null)
}

public fun Any.i(tag: String, message: String) {
    i(tag, message, null)
}

public fun Any.w(tag: String, message: String) {
    w(tag, message, null)
}

public fun Any.e(tag: String, message: String) {
    e(tag, message, null)
}

public fun Any.wtf(tag: String, message: String) {
    wtf(tag, message, null)
}

public fun Any.v(tag: String, message: String, exception: Exception?) {
    Log.v(tag, message, exception)
}

public fun Any.d(tag: String, message: String, exception: Exception?) {
    Log.d(tag, message, exception)
}

public fun Any.i(tag: String, message: String, exception: Exception?) {
    Log.i(tag, message, exception)
}

public fun Any.w(tag: String, message: String, exception: Exception?) {
    Log.w(tag, message, exception)
}

public fun Any.e(tag: String, message: String, exception: Exception?) {
    Log.e(tag, message, exception)
}

public fun Any.wtf(tag: String, message: String, exception: Exception?) {
    Log.wtf(tag, message, exception)
}
