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

import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import java.io.Serializable
import java.util.ArrayList


public fun Any.bundle(init: KaffeineBundle.() -> Unit): Bundle {
    val kaffeineBundle = KaffeineBundle()
    kaffeineBundle.init()
    return kaffeineBundle.pack()
}

public class KaffeineBundle {
    private val bundle = Bundle()

    public fun putBinder(key: String, value: IBinder?) {
        bundle.putBinder(key, value)
    }

    public fun putBoolean(key: String, value: Boolean) {
        bundle.putBoolean(key, value)
    }

    public fun putBooleanArray(key: String, value: BooleanArray) {
        bundle.putBooleanArray(key, value)
    }

    public fun putBundle(value: Bundle) {
        bundle.putAll(value)
    }

    public fun putBundle(key: String, value: Bundle?) {
        bundle.putBundle(key, value)
    }

    public fun putByte(key: String, value: Byte) {
        bundle.putByte(key, value)
    }

    public fun putByteArray(key: String, value: ByteArray) {
        bundle.putByteArray(key, value)
    }

    public fun putChar(key: String, value: Char) {
        bundle.putChar(key, value)
    }

    public fun putCharArray(key: String, value: CharArray) {
        bundle.putCharArray(key, value)
    }

    public fun putCharSequence(key: String, value: CharSequence?) {
        bundle.putCharSequence(key, value)
    }

    public fun putCharSequenceArray(key: String, value: Array<CharSequence?>?) {
        bundle.putCharSequenceArray(key, value)
    }

    public fun putCharSequenceArrayList(key: String, value: ArrayList<CharSequence?>?) {
        bundle.putCharSequenceArrayList(key, value)
    }

    public fun putDouble(key: String, value: Double) {
        bundle.putDouble(key, value)
    }

    public fun putDoubleArray(key: String, value: DoubleArray) {
        bundle.putDoubleArray(key, value)
    }

    public fun putFloat(key: String, value: Float) {
        bundle.putFloat(key, value)
    }

    public fun putFloatArray(key: String, value: FloatArray?) {
        bundle.putFloatArray(key, value)
    }

    public fun putInt(key: String, value: Int) {
        bundle.putInt(key, value)
    }

    public fun putIntArray(key: String, value: IntArray) {
        bundle.putIntArray(key, value)
    }

    public fun putIntegerArrayList(key: String, value: ArrayList<Int?>?) {
        bundle.putIntegerArrayList(key, value)
    }

    public fun putLong(key: String, value: Long) {
        bundle.putLong(key, value)
    }

    public fun putLongArray(key: String, value: LongArray) {
        bundle.putLongArray(key, value)
    }

    public fun putParcelable(key: String, value: Parcelable?) {
        bundle.putParcelable(key, value)
    }

    public fun putParcelableArray(key: String, value: Array<Parcelable?>?) {
        bundle.putParcelableArray(key, value)
    }

    public fun putParcelableArrayList(key: String, value: ArrayList<Parcelable?>?) {
        bundle.putParcelableArrayList(key, value)
    }

    public fun putSerializable(key: String, value: Serializable?) {
        bundle.putSerializable(key, value)
    }

    public fun putShort(key: String, value: Short) {
        bundle.putShort(key, value)
    }

    public fun putShortArray(key: String, value: ShortArray?) {
        bundle.putShortArray(key, value)
    }

    public fun putSize(key: String, value: Size?) {
        bundle.putSize(key, value)
    }

    public fun putSizeF(key: String, value: SizeF?) {
        bundle.putSizeF(key, value)
    }

    public fun putString(key: String, value: String?) {
        bundle.putString(key, value)
    }

    public fun putStringArray(key: String, value: Array<String?>?) {
        bundle.putStringArray(key, value)
    }

    public fun putSparseParcelableArray(key: String, value: SparseArray<Parcelable?>?) {
        bundle.putSparseParcelableArray(key, value)
    }

    public fun putStringArrayList(key: String, value: ArrayList<String?>?) {
        bundle.putStringArrayList(key, value)
    }

    public fun pack(): Bundle {
        return bundle
    }
}
