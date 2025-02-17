package com.example.task_012

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MyDialog {
    companion object {
        fun createDialog(context: Context, adapter: ArrayAdapter<User>) =
            AdapterView.OnItemClickListener {parent, v, position, id ->
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Внимание!")
                    .setMessage("Удалить пользователя?")
                    .setCancelable(true)
                    .setNegativeButton("Нет") {
                            dialog, which -> dialog.cancel()
                    }
                    .setPositiveButton("Да") {
                            dialog, which ->
                        val user = adapter.getItem(position)
                        adapter.remove(user)
                        Toast.makeText(context, "Пользователь удален: $user", Toast.LENGTH_LONG).show()
                    }.create()
                builder.show()
            }
    }
}


