package com.mobsandgeeks.kaffeine

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ListAdapter


public fun Context.alertDialog(init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(this)
    dialog.init()
    return dialog
}

public class Dialog(val context: Context) {
    private val builder = AlertDialog.Builder(context)

    var titleId: Int = -1
        set(value) {
            $titleId = value
            builder.setTitle($titleId)
        }

    var title: String? = null
        set(value) {
            $title = value
            builder.setTitle($title)
        }

    var messageId: Int = -1
        set(value) {
            $messageId = value
            builder.setMessage($messageId)
        }

    var message: String? = null
        set(value) {
            $message = value
            builder.setMessage($message)
        }

    var cancelable: Boolean = true
        set(value) {
            $cancelable = value
            builder.setCancelable($cancelable)
        }

    var customTitle: View? = null
        set(value) {
            $customTitle = value
            builder.setCustomTitle($customTitle)
        }

    var icon: Drawable? = null
        set(value) {
            $icon = value
            builder.setIcon($icon)
        }

    var iconId: Int = -1
        set(value) {
            $iconId = value
            builder.setIcon($iconId)
        }

    var iconAttribute: Int = -1
        set(value) {
            $iconAttribute = value
            builder.setIconAttribute($iconAttribute)
        }

    var inverseBackgroundForced: Boolean = false
        set(value) {
            $inverseBackgroundForced = value
            builder.setInverseBackgroundForced($inverseBackgroundForced)
        }

    var view: View? = null
        set(value) {
            $view = value
            builder.setView($view)
        }

    var viewId: Int = View.NO_ID
        set(value) {
            $viewId = value
            builder.setView($viewId)
        }

    public fun adapter(adapter: ListAdapter,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setAdapter(adapter, listener)
    }

    public fun cursor(cursor: Cursor, listener: (dialog: DialogInterface, which: Int) -> Unit,
            labelColumn: String) {
        builder.setCursor(cursor, listener, labelColumn)
    }

    public fun items(itemsId: Int, listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setItems(itemsId, listener)
    }

    public fun items(items: Array<CharSequence>,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setItems(items, listener)
    }

    public fun multiChoiceItems(items: Array<CharSequence>, checkedItems: BooleanArray,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(items, checkedItems, listener)
    }

    public fun multiChoiceItems(cursor: Cursor, isCheckedColumn: String, labelColumn: String,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, listener)
    }

    public fun multiChoiceItems(itemsId: Int, checkedItems: BooleanArray,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(itemsId, checkedItems, listener)
    }

    public fun positiveButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        positiveButton(context.getString(textId), listener)
    }

    public fun positiveButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setPositiveButton(text, listener)
    }

    public fun singleChoiceItems(items: Array<CharSequence>, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(items, checkedItem, listener)
    }

    public fun singleChoiceItems(items: ListAdapter, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(items, checkedItem, listener)
    }

    public fun singleChoiceItems(itemsId: Int, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(itemsId, checkedItem, listener)
    }

    public fun singleChoiceItems(cursor: Cursor, checkedItem: Int, labelColumn: String,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, listener)
    }

    public fun negativeButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        negativeButton(context.getString(textId), listener)
    }

    public fun negativeButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setNegativeButton(text, listener)
    }

    public fun neutralButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        neutralButton(context.getString(textId), listener)
    }

    public fun neutralButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setNeutralButton(text, listener)
    }

    public fun onCancelListener(listener: ((dialog: DialogInterface) -> Unit)?) {
        builder.setOnCancelListener(listener)
    }

    public fun onItemSelected(listener: AdapterView.OnItemSelectedListener) {
        builder.setOnItemSelectedListener(listener)
    }

    public fun onDismissListener(listener: ((dialog: DialogInterface) -> Unit)?) {
        builder.setOnDismissListener(listener)
    }

    public fun onKeyListener(
            listener: (dialog: DialogInterface, keyCode: Int, event: KeyEvent) -> Boolean) {
        builder.setOnKeyListener(listener)
    }

    public fun show() {
        builder.create().show()
    }
}
