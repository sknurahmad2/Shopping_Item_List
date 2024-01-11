package com.example.shoppingapp.dialoge

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingapp.R
import com.example.shoppingapp.data.ShoppingItem

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val button = findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            val name = findViewById<EditText>(R.id.editText2)?.text.toString()
            val amount = findViewById<EditText>(R.id.editText)?.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Fill All the information",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        findViewById<Button>(R.id.button2)?.setOnClickListener {
            cancel()
        }
    }
}